package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Topic_13_Handle_Alert {
    WebDriver driver;
    WebDriverWait explicitWait;

    By resultText = By.cssSelector("p#result");
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void  TC_01_Accept_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        //this wait until the alert is presented, if presented -> switch to alert, if not throw error message
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSecond(3);
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");

    }
    @Test
    public void TC_02_Confirm_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked: Cancel");
    }

    @Test
    public void TC_03_Prompt_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        String text = "Testing prompt";
        alert.sendKeys(text);
        sleepInSecond(2);
        alert.accept();
        Assert.assertEquals(driver.findElement(resultText).getText(),"You entered: " + text);
    }

    @Test
    public void TC_04_Authentication_Alert(){
        //cach 1: truyền thẳng user name & password vào url
        String user_name = "admin";
        String password = "admin";
        driver.get("https://" + user_name + ":" + password +"@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(
                By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"))
                .isDisplayed());
    }

    @Test
    public void TC_05_Authentication_Selenium4(){

        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulation! You must have the proper credentials.')]")).isDisplayed());
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

    public void selectItemInDropdown(String parentCss, String childItemCss, String expectedItemText){
        driver.findElement(By.cssSelector(parentCss)).click(); //"#number-button"
        sleepInSecond(3);

        //wait for all elements are presented in HTML
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss))); //"ul#number-menu div"
        //các items có kiểu dữ liệu là WebElement
        List < WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));

        //if item is present -> click(), else -> scroll until it presents and click
        //dùng for each: khai báo biến item đại diện cho các item trong List allItems, và có cùng kiểu dữ liệu WebElement
        for (WebElement item: allItems){
            String textItem = item.getText();
            if (textItem.equals(expectedItemText)){
                item.click();
                break; //item từ 9 -> 19 sẽ ko dc duyệt qua
            }
        }
    }

    public void selectEditableItemDropdown(String parentCss, String childItemCss, String expectedItemText){
        driver.findElement(By.cssSelector(parentCss)).sendKeys(expectedItemText);
        sleepInSecond(3);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        //các items có kiểu dữ liệu là WebElement
        List < WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));
        for (WebElement item: allItems){
            String textItem = item.getText();
            if (textItem.equals(expectedItemText)){
                item.click();
                break;
            }
        }

    }
}
