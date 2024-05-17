package javaTester;

public class Topic_11_Array_Object {
    String name;
    int age;
//      Constructor: hàm khởi tạo có tên trùng với class name
    public Topic_11_Array_Object(String name, int age){
        this.name = name;
        this.age = age;
        }
    public static void main(String[] args){
        //dùng mảng object khởi tạo đối 5 tượng
//        Topic_11_Array_Object[] students = new Topic_11_Array_Object[3];
//        students[0] = new Topic_11_Array_Object("Anna", 20);
//        students[1] = new Topic_11_Array_Object("Jimmy", 21);
//        students[2] = new Topic_11_Array_Object("John", 24);

        // Exercises 1
//        int num[] = {1,3,6,2,9,0};
//        int max = num[0];
//        for (int i = 0; i < num.length; i++) {
//            if (num[i] > max){
//                max = num[i];
//            }
//        }
//        System.out.println(max);

        //Exercise 2: tính tổng số đầu và cuối của 1 mảng
//        int number[] = {1,9,3,10};
//        int sum = number[0] + number[number.length-1];
//        System.out.println("sum is: " + sum);

        //Exercise 3: in ra các số chẵn
//        int allNum[] = {1,6,2,4,7,100};
//        for (int i = 0; i < allNum.length; i++) {
//            if (allNum[i] % 2 == 0){
//                System.out.println("So chan la: " + allNum[i]);
//            }

        //Exercise 4: tính tổng các số lẻ lớn hơn 0
//        int sumNum[] = {3,1,-9,6,2,-2,0};
//        int sumOfOdd = 0;
//        for (int i = 0; i < sumNum.length; i++) {
//            if (sumNum[i] % 2 != 0 && sumNum[i] > 0){
//                System.out.println("So le la: " + sumNum[i]);
//                sumOfOdd += sumNum[i];
//            }
//        }
//        System.out.println("Tong so le la: " + sumOfOdd);

        //Tinh trung binh cong cua cac so trong 1 mang
        int sum = 0;
        int allNum[] = {1,3,6,2,4,-6};
        for (int i = 0; i < allNum.length; i++) {
            //can write as: sum = sum + allNum[i];
            sum += allNum[i];
        }
        System.out.println("Tong cac so la: " + sum);
        //average is a float, therefor we need to cast division of 2 integers (which is also an integer) into a float
        float average = (float) sum / allNum.length;
        System.out.println("Trung binh cong la: " + average);

        }
}
