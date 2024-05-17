package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For_ForEach {
    public static void main(String[] args){
        //i = 0
        //0 < 10 -> đúng -> System.out.println(0);
        //i++: tăng i lên 1 unit -> i = 1
        // 1 < 10 -> đúng -> System.out.println(1);...
        //i++: tăng i lên 1 unit -> i = 2...
        //until i = 10 -> 10 < 10 sai -> kết thúc vòng for
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        //array, for, if
        String[] cityName = {"Hanoi", "Sai Gon", "Da Nang"};
        for (int c = 0; c < cityName.length ; c++) {
//            System.out.println(cityName[c]);
            if (cityName[c].equals("Hanoi")){
                System.out.println(cityName[c] + " is Vietnam's capital");
            }
            //khi dùng break, vòng for sẽ ko chạy qua các giá trị không thoả mãn điều kiện vòng if
            break;
        }

        //for each
        //using the array above
//        for (String city: cityName){
//            System.out.println(city);
//        }
        //Java Collection, Class: Array, Linked List, Interface: List, Set, Queue
        List<String> cityAddress = new ArrayList<String>();
        //add city during COMPILE (coding)
        cityAddress .add("Quang Ninh");
        //add city to the cityAddress list during RUN TIME
        for (String city: cityName){
            cityAddress.add(city);
        }

        //Test
        int number = 10;
        for (int i=0; i<=number; i++){
            if(i<5){
                System.out.println(i);
            }
            else{
                System.out.println("not less than 5");
            }
        }
    }
}
