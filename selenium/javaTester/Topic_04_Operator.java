package javaTester;

public class Topic_04_Operator {
    public static  void main (String[] args){
        int number = 10;
//        //number = number + 5
//        number += 5;
//        //15/5 = 3
//        System.out.println(number/5);
//        //15%6: lấy phần dư = 3 (15/6 = 2 dư 3 )
//        System.out.println(number%6);

        //firstly: print the number (10), then increase by 1 unit (11)
        System.out.println(number++);
        //firstly: increase by 1 unit, then print the number (now is 12)
        System.out.println(++number);
        for (int i = 0; i < 3; i++){
            System.out.println(i);
            if (i<2){
                System.out.println("value of i: " +i);
            }
        }
// AND/ OR CONDITIONS
        String address = "Da Nang";
        if (address!= "Da Nang" || address!= "Sai Gon"){
            System.out.println("Address is correct");
        }
        else {
            System.out.println("Address is incorrect");
        }
// CONDITIONS WITHOUT IF
        // if status is correct -> return true, else false
        boolean status = (address =="Da Nang") ? true:false;
        System.out.println(status);
    }
}
