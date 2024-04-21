package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_WebBrowser_Command_Scope {
    //Global variable: Biến được lưu ở phạm vi Class
    //dùng được cho tất cả các hàm ở trong 1 Class
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
    public void  TC_01(){
        //Local variable: Biến được lưu ở phạm vi Hàm (function)
        //dùng được trong cái hàm dc khai báo
        String homepageURL = "https://www.youtube.com/watch?v=rnthbrgaTaw&t=1s";
        //hàm này dùng biến local và chỉ dùng được khi biến đã được INIT
        driver.get(homepageURL);
        //nếu trong 1 hàm có 2 biến cùng tên, 1 là Global var và 1 là Local var, muốn dùng Global var
        // -> dùng từ khoá this
        driver.get(this.homepageURL);
        Assert.assertTrue(driver.getCurrentUrl().contains("abc"));
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
