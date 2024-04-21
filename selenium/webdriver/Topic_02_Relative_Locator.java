package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;

public class Topic_02_Relative_Locator {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public  void  TC_01_Relative_Locator(){
        driver.get("https://demo.nopcommerce.com/login");
        By passwordTextboxBy = By.cssSelector("input#Password");
        //or
//        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#Password"));
        By remembermeCheckbox = By.id("RememberMe");
        By forgotPasswordLink = By.cssSelector("span.forgot-password");
        By loginButton = By.cssSelector("button.login-button");
        WebElement remembermeText =  driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButton)
                .below(passwordTextboxBy)
                .toRightOf(remembermeCheckbox)
                .toLeftOf(forgotPasswordLink)
                .near(remembermeCheckbox)

        );
        driver.findElement(By.xpath("//input[@data-view-id = 'main_search_form_input']"));
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
