package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Checkbox_Radio {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void  TC_01_Default_Checkbox() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
//        By dualCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']");
//        if (!driver.findElement(dualCheckbox).isSelected()){
//            driver.findElement(dualCheckbox).click();
//            sleepInSecond(2);
//            Assert.assertTrue(driver.findElement(dualCheckbox).isSelected());
//        }
        By rearCheckbox = By.xpath("//label[text()='Rear side airbags']");
        if (!driver.findElement(rearCheckbox).isSelected()){
            driver.findElement(rearCheckbox).click();
            sleepInSecond(2);
            Assert.assertTrue(driver.findElement(rearCheckbox).isSelected());
        }

    }
    @Test
    public void TC_02_Radio_Button(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
    }

    @Test
    public void TC_03_Click_Menu_VueJS(){

    }

    @Test
    public  void TC_04_Editable_Dropdown(){
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
