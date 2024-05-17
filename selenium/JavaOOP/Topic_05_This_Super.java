package JavaOOP;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Topic_05_This_Super extends Topic_05_Base_Class_Super {
    private int firstNumber;
    private int secondNumber;
    private long shortTimeout = 15 ;
    private long longTimeout = 45 ;
    private WebDriver driver;
    public void setImplicitWait(){
        //super.longTimeout: which means it use the longTimeout of the parent class
        driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
    }
    public void clickToElement(){
        //ko dung super: gọi hàm ở class con hiện tại
        setImplicitWait();
        //dùng super: gọi hàm ở class cha
        super.setImplicitWait();
    }

//NOTE: this chỉ dùng trong phạm vi 1 class, super dùng dc ở các class khác. Chỉ dùng this/ super khi class cha và con có hàm cùng tên

    public Topic_05_This_Super(int firstNumber, int secondNumber) {
        //
       this.firstNumber = firstNumber;
       this.secondNumber = secondNumber;
    }

    public void sumNumber(){
        System.out.println("Sum is: " + (this.firstNumber + this.secondNumber));
    }
    public void showNumber(){
        //gọi hàm cùng class dùng this
        this.sumNumber();
    }

    public static void main(String[] args){
        Topic_05_This_Super topic = new Topic_05_This_Super(10, 8);

    }
}
