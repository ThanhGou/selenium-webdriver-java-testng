package javaTester;
//public class Topic_06_Exercises {
//    WebDriver driver;
//    @Test
//    public void TC_01(){
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
//        Scanner scanner = new Scanner(System.in);
//        int age = scanner.nextInt();
//        System.out.println(age);
//    }
//}
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_06_Exercises {
    static Scanner scanner = new Scanner(System.in);
    @Test
    public void TC_01() {
        int number = scanner.nextInt();
        if (number % 2 ==0){
            System.out.println("So " + number + " la so chan");
        }
        else {
            System.out.println("So " + number + " la so le");
        }
    }
    public  void TC_02(){
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        if (firstName.equals(secondName)){
            System.out.println("Names are the same");
        }
        else {
            System.out.println("Names are not the same");
        }
    }
    public void TC_03(){
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        if (number1>number2 && number1>number3){
            System.out.println("The biggest number is: " + number1);
        }
        else if(number2>number3){
            System.out.println("The biggest number is: " + number2);
        }
        else {
            System.out.println("The biggest number is: " + number3);
        }
    }

    public void TC_04(){
        float score = scanner.nextFloat();
        if (score<=10 && score>=8.5){
            System.out.println("Grade is A");
        } else if (score<8.5 && score>=7.5) {
            System.out.println("Grade is B");
        } else if (score<7.5 && score>5) {
            System.out.println("Grade is C");
        }
        else {
            System.out.println("Grade is D");
        }

    }
}
