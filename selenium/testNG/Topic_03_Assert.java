package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {
    WebDriver driver;
    @Test (groups = "group 1")
    public void test01(){
        String name = "abc";
        Assert.assertEquals(name, "abc");
        Assert.assertTrue(checkElement(By.cssSelector("")));
    }
    @Test (groups = "group 1")
    public void test02(){
        String name = "abc";
        Assert.assertEquals(name, "abc");
        Assert.assertTrue(checkElement(By.cssSelector("")));
    }
    private boolean checkElement(By elementLocator){
        return driver.findElement(elementLocator).isDisplayed();
    }
}
