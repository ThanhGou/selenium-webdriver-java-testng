package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_10_Handle_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;

    FluentWait <WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void  TC_01_Click_Menu_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropdown("#speed-button","ul#speed-menu div", "Medium" );
        sleepInSecond(3);

        selectItemInDropdown("#files-button","ul#files-menu div", "jQuery.js" );
        sleepInSecond(3);

        selectItemInDropdown("#number-button","ul#number-menu div", "15" );
        sleepInSecond(3);

        selectItemInDropdown("#salutation-button","ul#salutation-menu div", "Dr." );
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(),"Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button span.ui-selectmenu-text")).getText(),"jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button span.ui-selectmenu-text")).getText(),"15");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button span.ui-selectmenu-text")).getText(),"Dr.");

    }
    @Test
    public void TC_02_Click_Menu_ReactJS(){
        //similarly as JQuery
    }

    @Test
    public void TC_03_Click_Menu_VueJS(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");
        sleepInSecond(3);
    }

    @Test
    public  void TC_04_Editable_Dropdown(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectEditableItemDropdown("input.search","div.selected.item span","American Samoa");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "American Samoa");
        sleepInSecond(3);

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
