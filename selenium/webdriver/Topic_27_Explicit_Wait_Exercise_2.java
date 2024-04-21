package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_27_Explicit_Wait_Exercise_2 {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String uploadFileName1 = "screenshot1.png";
    String uploadFileName2 = "screenshot2.png";
    //File.separator: lấy đường dẫn có // hoặc \ tuỳ vào hệ điều hành
    String screenshot1FilePath = projectPath + File.separator + "test_files" + File.separator + uploadFileName1;
    String screenshot2FilePath = projectPath + File.separator + "test_files" + File.separator + uploadFileName2;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test
    public void TC_06_Ajax_Loading(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        driver.findElement(By.xpath("//a[text()='1']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*=RadCalendar1]>div.raDiv")));
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Monday, April 1, 2024");
    }

    @Test
    public void TC_07_Upload_File(){
        driver.get("https://gofile.io/welcome");
        //wait và verify loading icon hiển thị
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-boder"))));
        //hàm explicitWait sẽ trả về 1 web element nên có thể click button ở đây
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ajaxLink>button"))).click();
        //wait for all loading icons are dismissed
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-boder")))));
        //upload files
        By uploadBtn = By.cssSelector("input[type='file']");
        driver.findElement(uploadBtn).sendKeys(screenshot1FilePath + "\n" + screenshot2FilePath);
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-boder")))));
        //Wait progress bar dismissed
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress")))));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-boder")))));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='" + screenshot1FilePath + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']")))
                .isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='" + screenshot2FilePath + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']")))
                .isDisplayed());
    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }
   }

