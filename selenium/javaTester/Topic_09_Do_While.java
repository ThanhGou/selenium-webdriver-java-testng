package javaTester;

import java.util.Scanner;

public class Topic_09_Do_While {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        //Use "for"
        int number1 = scanner.nextInt();
        for (int i = number1; i < 100; i++) {
            if (i % 2==0){
                System.out.println("for: " + i);
            }
        }
        //Use "while"
        int number2 = scanner.nextInt();
        while (number2 < 100){
            if (number2 % 2==0){
                System.out.println("while: " + number2);
            }
            number2++;
        }
//        //Use "do-while"
        int number3 = scanner.nextInt();
        do{
            if (number3 % 2==0){
                System.out.println("do while: " + number3);
            }
            number3++;
        } while (number3 < 100);

        //Exercise: print all numbers which are in range [num1, num2] and %3 and %5 ==0
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        while (num1 < num2){
            if (num1 % 3 ==0 && num1 % 5 ==0){
                System.out.println("number is: " + num1);
            }
            num1++;
        }
    }
}
