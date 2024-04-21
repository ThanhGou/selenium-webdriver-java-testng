package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.List;

public class Topic_14_Actions_Part1_2_3 {
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
    public void TC_01_Hover_Tooltips(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement inputAge = driver.findElement(By.cssSelector("input#age"));
        actions.moveToElement(inputAge).perform();
        String toolTipsText = driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText();
        Assert.assertEquals(toolTipsText, "We ask for your age only for statistical purposes.");
    }

    @Test
    public void  TC_02_Hover_Login_Menu(){
        driver.get("https://www.myntra.com/");
        actions.moveToElement(driver.findElement(
                By.xpath("//a[text()='Kids' and @class = 'desktop-main']"))).perform();
        sleepInSecond(2);
        actions.click(driver.findElement(
                By.xpath("//a[text()='Boys Clothing' and @class = 'desktop-categoryName']"))).perform();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.title-title")).getText(),"Kids Wear Online Store");

    }

    @Test
    public void TC_03_Click_And_Hold(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allItems = driver.findElements(By.cssSelector("li.ui-state-default"));
        //Kiểm tra số lượng ô presented
        Assert.assertEquals(allItems.size(), 20);
        //Select a block of 15 squares: click on the 1st element and hold and move to the targeted element
        // then release and perform()
        //select items in row and column
        actions.clickAndHold(allItems.get(0))
                .pause(2000)
                .moveToElement(allItems.get(14))
                .pause(2000)
                .release()
                .perform();
        //select another item which is not in row or column
        actions.keyDown(Keys.COMMAND).perform();
        actions.click(allItems.get(16))
                .pause(2000)
                .keyUp(Keys.COMMAND)
                .perform();

        List<WebElement> allItemsSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selectee.ui-selected"));
        Assert.assertEquals(allItemsSelected.size(),13);
    }
    @Test
    public void TC_04_Double_Click(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        actions.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");

    }

    @Test
    public void TC_05_Right_Click(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        //right click on an element
        actions.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        //kiểm tra element dc hiển thị sau khi right click ở step trên
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
        //hover to element
        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSecond(2);
        //kiểm tra trạng thái của element sau khi hover:
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover")).isDisplayed());
        //click lên element
        actions.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSecond(2);
        //switch to alert and dismiss the alert
        driver.switchTo().alert().accept();
        sleepInSecond(2);

    }

    @Test
    public void TC_06_Drag_Drop_HTML4(){
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        WebElement originCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircle = driver.findElement(By.cssSelector("div#droptarget"));
        actions.dragAndDrop(originCircle, targetCircle).perform();
        sleepInSecond(2);
        Assert.assertEquals(targetCircle.getText(),"You did great!");
        Assert.assertEquals(
                Color.fromString(targetCircle.getCssValue("background-color"))
                        .asHex()
                        .toLowerCase(),"#03a9f4");

    }

    @Test
    public void TC_06_Drag_Drop_HTML5_CSS() throws IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        WebElement columnA = driver.findElement(By.cssSelector("div#column-a"));
        WebElement columnB = driver.findElement(By.cssSelector("div#column-b"));
        String projectPath =  System.getProperty("user.dir");
        String testFilePath = projectPath + "/test_files/drag_and_drop_helper.js";
        //get content file by jsContentFile
        String jsContentFile = getContentFile(testFilePath);
        //this cast the WebDriver instance to JavascriptExecutor, which allows us to execute JavaScript code.
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(jsContentFile);
        sleepInSecond(3);
    }

    @Test
    public void TC_06_Drag_Drop_HTML5_XPath(){
        driver.get("https://automationfc.github.io/kendo-drag-drop/");


    }

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
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
