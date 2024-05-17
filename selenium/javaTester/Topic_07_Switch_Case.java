package javaTester;

import java.util.Scanner;

public class Topic_07_Switch_Case {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        switch (month){
            //switch case không dùng với các operators, chỉ dùng vs int, string, enum
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng có 31 ngày");
                break;
            case 2:
                System.out.println("Tháng có 28 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng có 30 ngày");
                break;
            default:
                System.out.println("Tháng vừa nhập không hợp lệ");
                break;
        }

    // nhap vao so a, b, print sum (a,b)
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        String operator = scanner.next();
        switch (operator){
            case "+":
                System.out.println("a+b = " + (firstNum +secondNum));
                break;
            case "-":
                System.out.println("a-b = " + (firstNum -secondNum));
                break;
            case "*":
                System.out.println("a*b = " + (firstNum * secondNum));
                break;
            case "/":
                System.out.println("a/b = " + (firstNum / secondNum));
                break;
        }

    }
}
