package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_02_Data_Type {
    //GLOBAL VARIABLES HERE
    static int number;
    String studentName;
    public static void main(String[] args){
        //gọi dc đến global variable mà ko cần khởi tạo dữ liệu nếu variable là static
        // default value khi chạy hàm này cho giá trị 0
        //đây là hàm static nên chỉ gọi dc global variable có kiểu là static
        System.out.println(number);
        //HOẶC
        //gọi đến global variable thông qua object: tên_class = new tên class();
        //gọi đến variable thông qua object: topic.studentNam
        Topic_02_Data_Type topic = new Topic_02_Data_Type();
        System.out.println(topic.studentName);
        //LOCAL VARIABLES HERE
        // dùng local variables -> cần khởi tạo dữ liệu (init value) mới dùng dc, e.g.
        int studentID = 0;
        System.out.println(studentID);

//Dữ liệu nguyên thuỷ: Primitive Type (số)
        byte bNumber;
        short sNumber;
        int iNumber;
        long lNumber;
        float fNumber;
        double dNumber;
        char cChar;
        boolean bStatus;
// Dữ liệu tham chiếu: Reference Type
    //String
        String address = "abc";
    //Array
        String[] studentName = {"name 1", "name 2"};
        Integer[] studentScore = {1,2,3};
    //Class: topic01 đại diện cho kiểu dữ liệu là class Topic_02_Data_Type
        Topic_02_Data_Type topic01;
    //Interface
        WebDriver driver = null;
    //Object
        Object object;
    //Collection: List/ Set/ Queue/ Map
        List<WebElement> homepageURL = driver.findElements(By.cssSelector(""));
        Set<String> allWindows = driver.getWindowHandles();
        List<String> productName = new ArrayList<>();

    }
}
