package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_30_Fluent_Wait_Exercises {
    WebDriver driver;
    FluentWait<WebDriver> fluentDriver;
    FluentWait<WebElement> fluentWebElement;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        //khởi tạo fluentDriver sau khi đã khởi tạo driver
        fluentDriver = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
    }
    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        //condition 1
        fluentDriver.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                //wait for Hello World text presented
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']"))
                        .isDisplayed();
            }
        });

        //condition 2
       String get_Hello_Text =  fluentDriver.until(new Function<WebDriver, String>() {

            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).getText();
            }
        });
        Assert.assertEquals(get_Hello_Text, "Hello World!");
    }
    public void TC_02(){
        driver.get("https://automationfc.github.io/fluent-wait/");
        //khởi tạo fluentWebElement sau khi element đã có
        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));
        fluentWebElement = new FluentWait<WebElement>(countDownTime);
        fluentWebElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        //CONDITION
        fluentWebElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                return webElement.getText().endsWith("00");
            }
        });
    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }
   }

