package JavaOOP;

public class PersonOOP {
    private String personName;
    //Nested class/ Inner class
    public class Pupil{
        //Properties
        String name ="abc";
    }
    public static void main(String[] args){
        // khởi tạo object personOOP từ class PersonOOP
        PersonOOP personOOP = new PersonOOP();
        personOOP.personName = "";
        // khởi tạo object pupil từ class PersonOOP:
        //class_name.nested_class_name = object of class_name.new nested_class_name();
        PersonOOP.Pupil pupil = personOOP.new Pupil();
    }
}
