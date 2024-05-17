package JavaOOP;

public class Topic_Method {
     void showCarName(){
        System.out.println("Toyota");
    }
    static void showCarColor(){
        System.out.println("Orange");
    }
    public static void main(String[] args){
        //gọi hàm static khác(showCarColor()), ko thể gọi hàm non-static (showCarName())
        showCarColor();
        //gọi non-static method qua 1 instance/ object
        Topic_Method obj = new Topic_Method();
        obj.showCarName();

    }
}
