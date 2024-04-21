package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_Webbrowser_Command {
    WebDriver driver;
//    String osName = System.getProperty("os.name");
//    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void  TC_01(){
        String homepageURL = "https://www.youtube.com/watch?v=-wGaCWcZP_g&t=13s";
        //this command below is to open a url on a browser
        driver.get(homepageURL);
        //close a tab
        driver.close();
        //close a browser
        driver.quit();
        //get a list of items which have type = WebElement
        List<WebElement> items = driver.findElements(By.id("123"));

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
