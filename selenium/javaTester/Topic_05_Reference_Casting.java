package javaTester;

public class Topic_05_Reference_Casting {
    public String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void showName(){
        System.out.println("Member: " + name);
    }
    public static void main(String[] args){
        Topic_05_Reference_Casting member1 = new Topic_05_Reference_Casting();
        Topic_05_Reference_Casting member2 = new Topic_05_Reference_Casting();
        member1.setName("abc");
        member2.setName("xyz");
        member1.showName();
        member2.showName();
        //CASTING
        member1 = member2;
        member1.showName();
        member2.showName();

        member2.setName("bbb");
        member1.showName();
        member2.showName();
    }
}
