package javaTester;

public class Topic_05_Primitive_Casting {
    public static  void main (String[] args){
        // gán kiểu implicit: tự gán qua kiểu dữ liệu khác, ko cần phải chỉ ra kiểu du liệu
//        byte bNum = 120;
//        System.out.println(bNum);
//        short sNum = bNum;
//        System.out.println(sNum);
//        int iNum = sNum;
//        System.out.println(iNum);
//        long lNum = iNum;
//        System.out.println(lNum);
//        float fNum = lNum;
//        System.out.println(fNum);
//        double dNum = fNum;
//        System.out.println(dNum);

        // ép kiểu explicit: cần chỉ ra kiểu dữ liệu
        double dNum = 1234221312;
        System.out.println(dNum);

        float fNum = (float) dNum;
        System.out.println(fNum);

        long lNum = (long) fNum;
        System.out.println(lNum);

        int iNum =  (int) lNum;
        System.out.println(iNum);


    }
}
