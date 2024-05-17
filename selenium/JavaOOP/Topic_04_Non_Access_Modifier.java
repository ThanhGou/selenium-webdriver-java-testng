package JavaOOP;

public class Topic_04_Non_Access_Modifier {
    //Static: variable, method
    static String browserName = "Chrome";
    //Non-static var
    String serverName = "Staging";
    public static void main(String[] args){
        System.out.println(browserName);
        Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
        System.out.println(topic.serverName);
        //truy cập hàm thông qua object "topic"
        topic.clickToElement("Button");
        //truy cập hàm trực tiếp
        sendKeyToElement("key");
    }

    public void clickToElement(String elementName){
        System.out.println(elementName);
    }
    public static void sendKeyToElement(String elementName){
        System.out.println(elementName);
    }
    //Final method
    public final void setCarName(){

    }
}
