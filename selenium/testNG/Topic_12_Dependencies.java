package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_12_Dependencies {
    WebDriver driver;
    @BeforeClass
    public void beforeClass (){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test()
    public void TC_01_CreateNewUser()  {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }
    //If TC_01 failed, it's dependencies will be skipped
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_02_ViewAndSearchUser()  {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_03_UpdateExistingUser()  {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test(dependsOnMethods = "TC_03_UpdateExistingUser")
    public void TC_04_MoveUser()  {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test(dependsOnMethods = "TC_04_MoveUser")
    public void TC_05_DeleteUser()  {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
