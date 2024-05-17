package JavaOOP.Polymorphism;

public class Operator {
    public void sum(int a, int b){
        System.out.println(a + b);
    }

    public void sum(double a, double b){
        System.out.println(a + b);
    }

    public void sum(float a, float b){
        System.out.println(a + b);
    }

    public void sum(long a, long b){
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        Operator opr = new Operator();
        opr.sum(3, 4);
        opr.sum(3d, 4d);
        opr.sum(3.9f, 4.5f);
        opr.sum(1000l, 4000l);

    }
}
