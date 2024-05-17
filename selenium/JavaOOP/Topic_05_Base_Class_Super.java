package JavaOOP;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Topic_05_Base_Class_Super {
    public long shortTimeout = 15 ;
    public long longTimeout = 45 ;
    private WebDriver driver;
    public void setImplicitWait(){
        //super.longTimeout: which means it use the longTimeout of the parent class
        driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
    }
}
