package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public class Topic_30_Fluent_Wait_Knowledge {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentDriver;
    FluentWait<WebElement> fluentElement;
    FluentWait<String> fluentString;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();


    }
    @Test
    public void TC_01() {
     // INIT fluent wait
        fluentDriver = new FluentWait<WebDriver>(driver);
        fluentElement = new FluentWait<WebElement>(driver.findElement(By.cssSelector("")));
        fluentString = new FluentWait<String>("abc");

    //SETTINGS of fluent wait
        //set tong thoi gian
        fluentDriver.withTimeout(Duration.ofSeconds(10));
        //set polling time
        fluentDriver.pollingEvery(Duration.ofMillis(300));
        //Ignore exceptions
        fluentDriver.ignoring(NoSuchElementException.class);
        fluentDriver.ignoring(TimeoutException.class);

    //CONDITIONS
        fluentDriver.until(new Function<WebDriver, Object>() {

            @Override
            public Object apply(WebDriver webDriver) {
                return null;
            }
        });

        //CAN WRTE AS CHAINING
        fluentDriver.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        //this is an example with Object type is Boolean
                        return webDriver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }
    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }
   }

