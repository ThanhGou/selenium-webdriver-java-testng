package webdriver;

import org.openqa.selenium.WebDriver;

public class Topic_03_System_Info {
    public static void main(String args[]){
        String osName = System.getProperty("os.name");
        System.out.println(osName);
    }
}
