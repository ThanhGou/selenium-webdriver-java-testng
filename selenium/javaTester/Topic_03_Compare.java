package javaTester;

public class Topic_03_Compare {
    int number = 8;
    public static  void main (String[] args){
        //tạo ra 1 vùng nh cho biến x
        int x = 5;
        //tạo ra 1 vùng nh cho biến y
        int y = x;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        y = 10;
        // Primitive Type: giá trị của biến ko thay đổi: x vẫn = 5
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        Topic_03_Compare topic1 = new Topic_03_Compare();
        Topic_03_Compare topic2 = topic1;
        System.out.println("topic1 = " + topic1.number);
        System.out.println("topic2 = " + topic2.number);

// THAM CHIẾU
        topic2.number = 15;
        // Reference Type: giá trị của biến thay đổi theo: topic1 = 15 (vi kiểu tham chiếu dùng chung bộ nhows: topic 1 tham
        // chieu den topic2)
        System.out.println("topic1 = " + topic1.number);
        System.out.println("topic2 = " + topic2.number);


// KHOONG THAM CHIEU
        Topic_03_Compare topic3 = new Topic_03_Compare();
        Topic_03_Compare topic4 = new Topic_03_Compare();
        System.out.println("topic3 = " + topic3.number);
        System.out.println("topic4 = " + topic4.number);


    }
}
