package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    @Test
    public void TC_01_IF(){
        int studentID = 10;
        boolean status;
        // if studentID = 10 then status is true
        status = (studentID ==10);
        System.out.println(status);

        //EXAMPLE FOR != : Uncheck a checkbox
        WebDriver driver = null;
        WebElement checkbox1 = driver.findElement(By.cssSelector(""));
        if (checkbox1.isSelected()){
            checkbox1.click();
        }
        //Check a checkbox
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
    }
    @Test
    public void TC_02_IFELSE(){
        WebDriver driver;
        // If driver starts with Chrome -> use click function of Selenium WebElement,
        // else use click function of JavascriptExecutor
        System.setProperty("webdriver.firefox.driver", projectPath + "/browserDrivers/geckodriver");
        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();
        if (driver.toString().contains("firefox")){
            System.out.println("Click by Javascript Executor");
        }
        else {
            System.out.println("Click by Selenium WebElement");
        }

    }

}
