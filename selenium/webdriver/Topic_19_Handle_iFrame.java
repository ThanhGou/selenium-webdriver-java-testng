package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_19_Handle_iFrame {
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
    public void TC_01_Handle_iFrame(){
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInSecond(5);
        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));
        Assert.assertTrue(formIframe.isDisplayed());
        //switch to an iframe before interact with elements within the iframe
        driver.switchTo().frame(formIframe);
        //OR can swith to an iframe By element as below but not recommended since it can change
        //driver.switchTo().frame("frame-one85593366");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Freshman");
        //switch ra ngoài để thao tác với elements ngoài iframe
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        driver.findElement(By.cssSelector("div.auth-form__group button#login")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.auth-card div#message-error"))
                .getText(), "Username and password are both required.");
    }

    @Test
    public void TC_02_Handle_Frame(){
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        driver.switchTo().frame("login_page");
        driver.findElement(By.cssSelector("input[name = 'fldLoginUserId']")).sendKeys("Jonathan");
        sleepInSecond(2);
        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSecond(5);
//        Assert.assertTrue(driver.findElement(By.id("keyboard")).isDisplayed());
        driver.findElement(By.id("keyboard")).sendKeys("123456");
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
