package javaTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {
    public static void main(String[] args){
        //mảng 1 chiều với số lượng phần tử cố định
        int number[] = {10,11,14,3};
        String name[] = {"a", "x", "c"};
        //OR: int[] number = {10,11,14,3};
        //lấy phaanf tử thứ 2 trong mảng với index = 1
        System.out.println(number[1]);
//        System.out.println(name[1]);

        for (int i = 0; i < name.length; i++) {
            if (name[i].equals("x")){
                System.out.println(name[i]);
            }
        }
        //khai báo mảng 1 chiều với số lượng phần tử có thể thay đổi
        ArrayList<String> address = new ArrayList<String>();
        for (String add: address) {
            address.add(add);
        }
        //convert Array sang Array List
        List<String> names = Arrays.asList("abc", "axd");
        for (String name1 : names){
            System.out.println("Name: " + name1);
        }
//      Convert an array to String
        String name_2 = Arrays.toString(name);
        System.out.println(name_2);

    }
}
