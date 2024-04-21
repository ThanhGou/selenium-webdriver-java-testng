package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_09_Handle_Default_Dropdown {
    WebDriver driver;
    String firstName = "Anna", lastName = "Nguyen", email = getEmailAddress(), company_name = "abc",
    password = "123456", confirm_pw = "123456", day = "1", month = "February", year = "2000";
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void  TC_01_Register() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();
        sleepInSecond(2);
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dayDropdown.selectByVisibleText(day);
        //or it can be shorten as:
        //new Select (driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("2");
        //verify number of options
        List<WebElement> dayOptions = dayDropdown.getOptions();
        Assert.assertEquals(dayOptions.size(), 32);

        Select monthDropdown = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        monthDropdown.selectByVisibleText(month);
        Select yearDropdown = new Select(driver.findElement(By.name("DateOfBirthYear")));
        yearDropdown.selectByVisibleText(year);

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(company_name);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirm_pw);
        driver.findElement(By.id("register-button")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    }
    @Test
    public void TC_02_Login(){
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSecond(3);
        driver.findElement(By.className("ico-account")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),email);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),company_name);

        String day_text = new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText();
        Assert.assertEquals(day_text, day);

        String month_text = new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText();
        Assert.assertEquals(month_text, month);

        String year_text = new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText();
        Assert.assertEquals(year_text, year);
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

    public String getEmailAddress(){
        Random random_email = new Random();
        return "anna" + random_email.nextInt(1000) + "@gmail.com";
    }

}
