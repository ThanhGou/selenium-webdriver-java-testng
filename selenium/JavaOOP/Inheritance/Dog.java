package JavaOOP.Inheritance;

//Vừa extends, vừa implements
public class Dog extends Animal implements Runnable {
    public void run()
    {
        System.out.println("Running...");
    }
}
