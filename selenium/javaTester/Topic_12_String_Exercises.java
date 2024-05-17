package javaTester;

public class Topic_12_String_Exercises {
    public static void main(String[] args){
        String courseName = "Automation Testing";
        char courseNameArray[]= courseName.toCharArray();
        int count = 0;
        for (char character : courseNameArray) {
            //tìm các ký tự dc viết hoa trong khoảng từ A-Z
            if (character <= 'Z' && character >= 'A'){
                count++;
            }
        }
        System.out.println("Tong so ky tu co uppercase: " + count);

        //another example: count all characters which is "a"
        int countChar = 0;
        for(char c : courseNameArray){
            if (c=='t'){
                countChar++;
            }
        }
        System.out.println("Count 't': " + countChar);

    }
}
