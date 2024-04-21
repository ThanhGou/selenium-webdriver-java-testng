package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Handle_Dialog {
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
    public void TC_01_Fixed_Popup_In_DOM(){
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.cssSelector("button.login_")).click();
        sleepInSecond(2);
        By loginPopup = By.cssSelector("div[id='modal-login-v1'][style]>div");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("abc");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("123123");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.btn-v1.btn-login-v1")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.row.error-login-panel"))
                .getText(), "Tài khoản không tồn tại!");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.close")).click();
        //the popup is in DOM after being closed
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());

    }

    @Test
    public void  TC_02_Handle_Popup_Not_In_DOM(){
        driver.get("https://tiki.vn/");
        driver.findElement(By.cssSelector("div[data-view-id = 'header_header_account_container']")).click();
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());
        driver.findElement(By.cssSelector("p.login-with-email")).click();
        driver .findElement(By.xpath("//button[text() = 'Đăng nhập']")).click();
        Assert.assertEquals(driver.findElement(
                By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]"))
                .getText(), "Email không được để trống");
        Assert.assertEquals(driver.findElement(
                        By.xpath("//input[@type='password']/parent::div/following-sibling::span"))
                .getText(), "Mật khẩu không được để trống");
        driver.findElement(By.cssSelector("button.btn-close")).click();
        //the popup is not in DOM after being closed: use findElements(), but this function takes 30s to run
        //-> set implicitlyWait to 5s (fix tạm)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(),0);
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
