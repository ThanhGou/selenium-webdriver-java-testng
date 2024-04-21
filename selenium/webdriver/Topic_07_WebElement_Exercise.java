package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Exercise {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void  TC_01_Element_Display() throws InterruptedException{
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()){
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation testing");
            System.out.println("item is displayed");
        }
        else {
            System.out.println("item is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Checkbox is clicked");
        }
        else {
            System.out.println("item is not clicked");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            System.out.println("Name User 5 is shown");
        }
        else {
            System.out.println("Name User 5 is not shown");
        }

//        Assert.assertTrue(driver.findElement(By.cssSelector("input#mail")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed());
//        Assert.assertFalse(driver.findElement(By.xpath("//h5[text() = 'Name: User5']")).isDisplayed());

    }
    @Test
    public void  TC_02_Element_Enabled(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("#disable_password")).isEnabled()){
            System.out.println("Item is enabled");
        }
        else {
            System.out.println("Item is disabled");
        }
    }
    @Test
    public void  TC_03_Element_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        //click a radio button
        driver.findElement(By.cssSelector("input#under_18")).click();
//        click a checkbox
        driver.findElement(By.cssSelector("input#java")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input#java")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());

    }
    @Test
    public  void  TC_04_MailChimp(){
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("a@gmail.com");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
    }

    @Test
    public void TC_01_Login_Empty_Email_Pw(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");

    }
    //Handle textbox and text area
    @Test
    public void TC_02_Login_Invalid_Email_Pw(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title=\"My Account\"]")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("qqq@gmail.1");
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    //Handle dropdown
    @Test
    public void TC_01_Dropdown(){

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
