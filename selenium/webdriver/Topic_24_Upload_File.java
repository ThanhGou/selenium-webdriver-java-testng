package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_24_Upload_File {
    WebDriver driver;
    Actions actions;
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
        actions = new Actions(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
    @Test
    public void TC_01_Upload_Single_File(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadBy = By.cssSelector("input[name='files[]']");
        driver.findElement(uploadBy).sendKeys(screenshot1FilePath);
        driver.findElement(uploadBy).sendKeys(screenshot2FilePath);
        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));
        for(WebElement button: startButtons){
            button.click();
            sleepInSecond(3);
        }
    }
    @Test
    public void TC_02_Upload_Multiple_Files(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadBy = By.cssSelector("input[name='files[]']");
        //upload multiple files
        driver.findElement(uploadBy).sendKeys(screenshot1FilePath + "\n" + screenshot2FilePath);
        //the rest of implementation is similar as TC_01 above



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
   }

