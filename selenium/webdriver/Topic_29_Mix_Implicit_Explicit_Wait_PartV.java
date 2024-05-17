package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_29_Mix_Implicit_Explicit_Wait_PartV {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_Only_Implicit_Found(){
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");
        //tìm thấy element luôn ko cần chờ hết implicit wait timeout
        driver.findElement(By.cssSelector("input#email"));
    }
    @Test
    public void TC_02_Only_Implicit_Not_Found(){
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");
        //khong tìm thấy element -> polling mỗi 0.5s tìm lại một lần, cho đến khi timeout (hết 5s)
        //throw Exception NoSuchElement...
        driver.findElement(By.cssSelector("input#abc"));
    }
    @Test
    public void TC_03_Only_Explicit_Found(){
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //tìm thấy element ko cần chờ hết 5s
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
    }
    @Test
    public void TC_04_Only_Explicit_Not_Found_Param_By(){
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //khong tìm thấy element -> polling mỗi 0.5s tìm lại một lần, cho đến khi timeout (hết 5s)
        //throw TimeOutException
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#abc")));
    }

    @Test
    public void TC_05_Only_Explicit_Not_Found_Param_WebElement(){
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println("Start time: " +getDateTimeNow());
        try {
            //cannot find the element then the TC fail, throw exception NoSuchElement and not execute function visibilityOf()
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#abc"))));
        } catch (Exception e) {
            System.out.println("End time: " +getDateTimeNow());
            throw new RuntimeException(e);
        }
    }
    @Test
    public void TC_06_Mix_Implicit_Explicit(){
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //các hàm findElement(s) chỉ bị ảnh hưởng bởi implicit, nhưng implicit setting có ảnh hưởng
        //đến các hàm dùng explicit
        System.out.println("Start time: " + getDateTimeNow());
        //dùng try catch để thực thi hàm in ra End time
        try {
            //việc tìm kiếm element sẽ bằng thời gian implicit wait cộng thêm N seconds vì:
            // hàm visibilityOfElementLocated() thực thi việc findElement (dùng implicit wait)
            //hết thời gian implicitwait, nếu chưa hết timeout của explicit wait (còn N seconds) -> chờ hết N seconds
            //lưu ý: implicitwait chạy trước explicitwait, normally là 0.5~1 giây
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#abc")));
        } catch (Exception e) {
            System.out.println("End time: " + getDateTimeNow());
            throw new RuntimeException(e);
        }
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

