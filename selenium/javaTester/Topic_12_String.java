package javaTester;

public class Topic_12_String {
    public static void main(String[] args){
        String schoolName = "Test School";
        String schoolAddress = "Hanoi";

        System.out.println("Get length: " + schoolName.length());
        System.out.println("Get index: " + schoolName.charAt(2));
        System.out.println("Map string: " + schoolName.concat(schoolAddress) );
        //OR: System.out.println("Map string: " + schoolName + schoolAddress);

        //equals
        System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi: " + schoolName.equals(schoolAddress));
        System.out.println("Kiem tra 2 chuoi bang nhau tuong doi: " + schoolName.equalsIgnoreCase("test SCHOOL"));

        //start/ end with/ contains
        System.out.println("Bat dau bang ky tu: " + schoolName.startsWith("Test"));
        System.out.println("Co chua ky tu: " + schoolName.contains("ol"));
        System.out.println("Ket thuc bang ky tu: " + schoolName.endsWith("ol"));

        //vi tri cua mot (chuoi) ky tu: lay vi tri cua ky tu dau tien
        System.out.println("Vi tri cua ky tu: " + schoolName.indexOf("ol"));

        //tach chuoi
        System.out.println("Vi tri cua ky tu: " + schoolName.substring(8, 10));

        String result = "Viewing page 1 of 10";
        //this split into an array
        String results[] = result.split(" ");
        //get page number in the example above, which has index = 2
        System.out.println(results[2]);

        //Replace
        String price = "$100.00";
        price =  price.replace("$", "a");
        //convert to float using Float.parseFloat()
//        float newPrice = Float.parseFloat(price);
        //convert to String using String.valueOf()
        String newPrice = String.valueOf(price);
        System.out.println(newPrice);


        // Trim
        String text = "    number   1  ";
        System.out.println(text.trim());
        String text1 = " ";
        //false
        System.out.println("Empty: " + text1.isEmpty());
        //true
        System.out.println("Blank: " + text1.isBlank());

        //Exercises

     }
}
