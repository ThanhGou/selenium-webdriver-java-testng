package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_26_Implicit_Wait {
    WebDriver driver;
    Actions actions;
    WebDriverWait explicitWait;
    FluentWait fluentWait;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //these Wait below applied for Selenium version 4
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
        driver.get("https://www.facebook.com/");

    }
    @Test
    public void TC_01_Find_Element(){
        //tìm thấy element trong khoảng thời gian dc set -> ko cần chờ hết timeout
        driver.findElement(By.cssSelector("input#email"));
        // tìm thấy nhiều hơn 1 element -> ko cần chờ hết timeout và trả về 1 element đầu tiên được tìm thấy
        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("abc");

        //ko tìm thấy element -> chờ hết timeout, trong thời gian timeout cứ 0.5s tìm lại element một lần
        // nếu tìm thấy -> trả về element và move qua step tiếp theo, else chờ hết timeout và throw exception,
        // và ko chạy các step sau
        driver.findElement(By.cssSelector("input[name='reg_email__']"));
    }

    @Test
    public void TC_02_Find_Elements(){
        List <WebElement> listElements;
        //tìm thấy chỉ 1 element trong khoảng thời gian dc set -> ko cần chờ hết timeout, return list element
//        listElements = driver.findElements(By.cssSelector("input#email"));
//        System.out.println("List: " + listElements.size());
        //tìm thấy nhiều hơn 1 element trong khoảng thời gian dc set -> ko cần chờ hết timeout, return list element
//        listElements = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
//        System.out.println("List: " + listElements.size());

        //ko tìm thấy element -> chờ hết timeout, trong thời gian timeout cứ 0.5s tìm lại element một lần
        // nếu tìm thấy -> trả về list element và move qua step tiếp theo, else chờ hết timeout, trả về
        // list element rỗng và chạy các step sau
       listElements = driver.findElements(By.cssSelector("input[name='reg_email__']"));
        System.out.println("List: " + listElements.size());
        System.out.println("End time: " + getDateTimeNow());
    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }
    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }
   }

