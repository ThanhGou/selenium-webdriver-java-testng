package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_04_Xpath_Css {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }
    @Test
    public  void  Register_01_Empty_Data(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type = 'submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public  void  Register_02_Invalid_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("LaLaLa");
        driver.findElement(By.id("txtEmail")).sendKeys("a@gmail");
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
    }

    @Test
    public  void  Register_03_Incorrect_Confirm_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public  void  Register_04_Invalid_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public  void  Register_05_Invalid_Confirm_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public  void  Register_06_Invalid_Phone_Number(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
