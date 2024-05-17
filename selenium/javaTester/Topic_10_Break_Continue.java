package javaTester;

public class Topic_10_Break_Continue {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("gia tri cua i: " + i);
            //mỗi lần chạy của for i sẽ apply cho tất cả các lần chạy của for j
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    continue;
                }
                System.out.println("gia tri cua j: " + j);
                //j se bang: 0, 1, 2, 4
            }
        }
    }
}
