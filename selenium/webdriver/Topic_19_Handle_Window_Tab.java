package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_19_Handle_Window_Tab {
    WebDriver driver;
    Actions actions;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        actions = new Actions(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
    @Test
    public void TC_01_Handle_Window(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(3);
        switchWindowByTitle("Google");
        driver.findElement(By.cssSelector("textarea[title = 'Tìm kiếm']")).sendKeys("Selenium");
        sleepInSecond(3);
        switchWindowByTitle("Facebook");
        String currentWindowID = driver.getWindowHandle();
        closeAllWindowsExcludeCurrentWindow(currentWindowID);
        sleepInSecond(5);
    }

    @Test
    public void TC_02_Handle_Window(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(3);
        driver.findElement(
                By.xpath("//a[@title = 'Sony Xperia']/parent::h2/following-sibling::div[@class = 'actions']//a[text()='Add to Compare']"))
                .click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");
        driver.findElement(
                        By.xpath("//a[@title = 'IPhone']/parent::h2/following-sibling::div[@class = 'actions']//a[text()='Add to Compare']"))
                .click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product IPhone has been added to comparison list.");
        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        switchWindowByTitle("Products Comparison List - Magento Commerce");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(), "COMPARE PRODUCTS");
        //switch to window
        switchWindowByTitle("Mobile");
        driver.findElement(By.cssSelector("input#search")).sendKeys("Motorola");
        sleepInSecond(3);
    }

    @Test
    public void TC_03_Handle_Window_Selenium4(){
        driver.get("https://dictionary.cambridge.org/vi/");
        //hàm newWindow() sẽ sinh ra 1 browser window mới và switch focus qua window này
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        // mở 1 url mới trên browser window vừa dc tạo
        newTab.get("url here");

    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }

    public void  switchWindowByTitle(String expectedTitle){
        //lấy ID của tất cả các tab
        Set<String> allIDs = driver.getWindowHandles();
        for(String id: allIDs){
            driver.switchTo().window(id);
            //get title of the current window tab
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }

    public void closeAllWindowsExcludeCurrentWindow(String currentWindowID){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id: allIDs){
            if (!id.equals(currentWindowID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindowID);
    }
    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
