package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_Invocation {
    WebDriver driver;
    @Parameters({"browser","version"})
    @BeforeClass
    public void beforeClass (String browserName, String browserVersion){
        if(browserName.equals("Chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equals("Firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            throw new RuntimeException("Browser name not valid");
        }
        System.out.println("Browser" + browserName + "with version" +browserVersion);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(invocationCount = 3)
    public void TC_01_LoginToSystem()  {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");
        driver.findElement(By.xpath("//*[@id='send2']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));

//        // ....
//
//        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
//        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
