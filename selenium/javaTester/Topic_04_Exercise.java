package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Topic_04_Exercise {
    WebDriver driver;
    @Test
    public void swapNumer(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        int a = 5;
        int b = 6;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);


    }
}
