package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public  void  TC_01_ID(){
        //8 locator
        //id, name, class (same as HTML attribute): fastest speed
        //find element by className
        driver.findElement(By.className("header-logo"));
        //find element by id
        driver.findElement(By.id("FirstName")).sendKeys("student first name");
        //find element by name
        driver.findElement(By.name("LastName")).sendKeys("student last name");
        //find element by tag name
        driver.findElements(By.tagName("input"));
        //find element by link text
        driver.findElement(By.linkText("About us"));
        //find element by partial link text
        driver.findElement(By.partialLinkText("About"));
        // find element by CSS selector with ID
        driver.findElement(By.cssSelector("#Email")).sendKeys("a@gmail.com");
        //find element by CSS selector with Class
        driver.findElement(By.cssSelector(".header-logo"));
        //find element by CSS selector with name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        //find element by CSS selector with link
        driver.findElement(By.cssSelector("a[href='/cart']"));

        //find element by Xpath
        //find element by className
        driver.findElement(By.xpath("//div[@class='header-logo']"));
        //find element by id
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("student first name");
        //find element by name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("student last name");
        //find element by tag name
        driver.findElements(By.xpath("//input"));
        //find element by link text
        driver.findElement(By.xpath("//a[text() = 'About us']"));
        // find element by CSS selector with ID
        driver.findElement(By.xpath("#Email")).sendKeys("a@gmail.com");
        //find element by CSS selector with Class
        driver.findElement(By.xpath(".header-logo"));
        //find element by CSS selector with name
        driver.findElement(By.xpath("input[name='FirstName']"));
        //find element by CSS selector with link
        driver.findElement(By.xpath("//a[@href='/cart']"));
        //find element by partial link text
        driver.findElement(By.xpath("//a[contains(@href, 'cart')]"));
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
