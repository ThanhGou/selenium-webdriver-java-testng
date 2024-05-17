package JavaOOP;

public class Topic_07_Overloading {
    private int firstNum;
    private int secondNum;
    //TÍNH ĐA HÌNH: Các hàm có cùng tên nhưng khác tham số hoặc khác kiểu dữ liệu của tham số, khác số lượng
    public void sumNumber(){
        int sumNum = this.firstNum + this.secondNum;
        System.out.println("Sum is: " + sumNum);
    }
    public void sumNumber(int num){
        System.out.println("Num is: " + num);
    }

    public void sumNumber(int firstNum, int secondNum){
        int sumNum = this.firstNum + this.secondNum;
        System.out.println("Sum is: " + sumNum);
    }

    public void sumNumber(float firstNum, float secondNum){
        int sumNum = this.firstNum + this.secondNum;
        System.out.println("Sum is: " + sumNum);
    }

    public void sumNumber(int firstNum, float secondNum){
        int sumNum = this.firstNum + this.secondNum;
        System.out.println("Sum is: " + sumNum);
    }
    public static void main(String[] args) {

    }
}
