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
import java.util.ArrayList;
import java.util.List;

public class Topic_07_WebElement_Command {
    //Global variable: Biến được lưu ở phạm vi Class
    //dùng được cho tất cả các hàm ở trong 1 Class
    WebDriver driver;
    //Khai báo: declaration
    String homepageURL;
    //Khai báo và khởi tạo: declaration & init
    String homepageTitle = "Homepage Title";

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("url here");
    }
    @Test
    public void  TC_01(){
        //syntax tương tác vs web element: driver.findELement(s).some_action()
        driver.findElement(By.id("")).sendKeys("something here");
        //another e.g
        WebElement element_01 = driver.findElement(By.xpath("Xpath here"));
        element_01.click();

        //find element inside another element
        driver.findElement(By.id("parent element")).findElement(By.xpath("child element"));
        //or in another way
        driver.findElement(By.cssSelector("parent element child element"));

        //list WebElement: Java Generic
        List<WebElement> list_items = driver.findElements(By.id(""));

        //Java non-Generic example: không cần truyền vào kiểu dữ liệu, có thể gán bất kì giá trị nào
        ArrayList name = new ArrayList<>();
        name.add("string or number ");

        //Java Generic example: truyền vào kiểu dữ liệu trong <>
        ArrayList<String> address = new ArrayList<>();
        address.add("abc");
        //không thể truyền vào int vì buộc phải truyền vào String

        //Verify 1 checkbox, radio, defautl dropdown đã dc Selected hay chưa: trả về boolean
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        //Verify 1 dropdown (default/ custom)
        Select dropdown = new Select(driver.findElement(By.id("123")));

        //Verify 1 element co thao tac dc ko, not read-only
        Assert.assertTrue(driver.findElement(By.id("123")).isEnabled());

        //HTML element: e.g attribute name is title -> get attribute's value:
        driver.findElement(By.id("")).getAttribute("title");

        //interact with tab Accessibility/ Properties trong Element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("");
        driver.findElement(By.id("")).getDomProperty("");

        //for Form - submit a form
        driver.findElement(By.id("")).submit();

        //get text
        driver.findElement(By.id("")).getText();
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
