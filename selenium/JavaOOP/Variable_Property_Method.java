package JavaOOP;

public class Variable_Property_Method {
    //With example below: GLOBAL VARIABLE: chỉ dc sử dụng trong 1 class, nếu sử dụng ở class khác -> gọi là instance variable
    //Access modifier: private
    //Data type: String
    //Variable name: studentName
    //Variable value: "Anna"
    private String studentName = "Anna";

    //STATIC VARIABLE: phaạm vi sử dụng: dùng được trực tiếp trong hàm static, không caanf thông qua object
    public static String studentAddress = "Hanoi";

    //PRIVATE VARIABLE: phaạm vi sử dụng: trong class hiện tại
    private static String studentPhone = "0992093929";

    //FINAL VARIABLE: không cho phép override
    final String country = "Viet Nam";

    //STATIC FINAL VARIABLE: Hằng số, ko dc ghi đè, cho phép truy cập rộng rãi
    static final float piNumber = 3.14f;


    public Variable_Property_Method(String studentName) {
        //Local variable trong phạm vi constructor
        String studentID = "";
    }

    public static void main(String[] args){
        String studentName = "any name";
        //duùng biến static của class
        studentAddress = "Da Nang";
        if(studentName.startsWith("any")){
            //local variable trong phạm vi 1 block code
            int number = 100;
            //gọi trực tiếp static var của class mà không cần thông qua Object nào
            System.out.println(Variable_Property_Method.studentAddress);
        }
        else {
            System.out.println(Variable_Property_Method.studentPhone);
        }
    }
    // Use void: when the method execute an action
    public void display(){
        //LOCAL VARIABLE TRONG PHẠM VI HÀM
        String studentName = "bla bla";
    }
}
