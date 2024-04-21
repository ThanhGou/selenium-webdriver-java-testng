package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Shadow_Dialog {
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
    public void TC_01_Shadow_DOM(){
        driver.get("https://automationfc.github.io/shadow-dom/");
        //lấy element locator của shadow DOM 1
        WebElement shadowHostElement =  driver.findElement(By.cssSelector("div#shadow_host"));
        //getShadowRoot() trả về kiểu dữ liệu là SearchContext, dòng dưới đây khởi tạo 1 biến với kiểu dữ liệu đó
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();
        //dùng shadowRootContext để tìm element bên trong shadow DOM 1 thay vì dùng driver
        // vì driver ko thao tác dc với shadow root element
        String getText = shadowRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        Assert.assertEquals(getText, "some text");
        //get all inputs
        List<WebElement> listInput = shadowRootContext.findElements(By.cssSelector("input"));

        //find element of shadow DOM 2 which is nested in shadow DOM 1
        WebElement nestedShadowHostElement = shadowRootContext.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowRootContext =  nestedShadowHostElement.getShadowRoot();
        String nestedText = nestedShadowRootContext.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        Assert.assertEquals(nestedText,"nested text");


    }

    @Test
    public void  TC_02_Shadow_DOM_Shopee(){
        driver.get("https://shopee.vn");
        sleepInSecond(5);
        WebElement shadowHostElement = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();
        // Verify popup hiển thị
        if (shadowRootContext.findElement(By.cssSelector("div#home-popup__content")).isDisplayed()){
            shadowRootContext.findElement(By.cssSelector("div#shopee-popup__close-btn")).click();
        }
        else {
            driver.findElement(By.cssSelector("input#shopee-searchbar-input__input")).sendKeys("abc");
            sleepInSecond(3);
            driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();

        }
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
