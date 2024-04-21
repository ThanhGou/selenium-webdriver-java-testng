package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_WebBrowser_Command_Assert {
    WebDriver driver;
    //Khai báo: declaration
    String homepageURL;
    //Khai báo và khởi tạo: declaration & init
    String homepageTitle = "Homepage Title";

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void  verifyTestNG(){
        // Testing framework (Unit test, Integration test, UI test: Java có nhiều thư viện để verify dữ liệu:
        //e.g. TestNG 4 or 5, JUnit, Assert J
        Assert.assertTrue(driver.getCurrentUrl().contains("abc"));

        //các hàm trả về kiểu dữ liệu boolean thường có syntax this.abc
        driver.findElement(By.id("")).isDisplayed();

        //Assert Equal
        Assert.assertEquals(driver.getCurrentUrl(),"url here");
        //apply cho findElement
        driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().fullscreen();
        //Test responsive
        driver.manage().window().setSize(new Dimension(1360, 786));
        //Một số hàm để điều hướng trang web
        driver.navigate().to("url here");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // Thao tác với chuyển Alert message
        driver.switchTo().alert().sendKeys("abc");

        // Thao tác với chuyển sang window khacs
        String windowID = driver.getWindowHandle();
        //hàm này truyền vào windowID
        driver.switchTo().window(windowID);

        // Thao tác với chuyển Frame/iFrame: switch bang Index/ID/Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("103");
        driver.switchTo().frame(driver.findElement(By.id("123")));

        //Switch ve HTML chua frame trc do
        driver.switchTo().defaultContent();
        //Switch tu frame ben trong ra frame ben ngoai
        driver.switchTo().parentFrame();


    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
