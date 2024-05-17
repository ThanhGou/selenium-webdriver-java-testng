package JavaOOP;

import JavaOOP.Overriding.Overriding_Employee;
import JavaOOP.Overriding.Overriding_Person;
import JavaOOP.Overriding.Overriding_Student;

public class Testing_Demo {
    public static void main(String[] args){
//        Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();
////        topic.personName = "Test automation";
////        //input invalid value: age cannot be a negative number
////        topic.personAge = -10;
////        topic.personPhone = 1299393;
////        topic.personBankAmount = -100;
////        topic.showPersonInfo();

        Overriding_Person p = new Overriding_Employee();
        p.eat();
        Overriding_Student stu = new Overriding_Student();
        stu.eat();
        Overriding_Employee emp = new Overriding_Employee();
        emp.eat();
    }
}
