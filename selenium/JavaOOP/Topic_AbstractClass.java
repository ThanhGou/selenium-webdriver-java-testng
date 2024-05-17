package JavaOOP;

public abstract class Topic_AbstractClass {
    public void showComputerPerformance(){
        System.out.println("Show computer performance");
    }
    // làm khung để cho các class con kế thừa nó phải override lại
    //abstract method chỉ dc define trong abstract class
    //1 abstract method ko có phần body {}
    public abstract void showComputerRam();
}
