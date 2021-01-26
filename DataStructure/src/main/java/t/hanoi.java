package t;

public class hanoi {
    public void hanoi(int n, char A, char B, char C, char D,int x) {
        if (n >0) {
            hanoi(n - 1, A, D, B,C, x);
            hanoi_basic_3(n-x,A,B,C);
            hanoi(n - 1, D, B, A,C, x);
        }
    }
    public void hanoi_basic_3(int n, char A, char B, char C) {
        if (n >0) {
            hanoi_basic_3(n - 1, A, B,C);
            move(n,A,C);
            hanoi_basic_3(n - 1, B, C,A);
        }
    }

     void move(int n,char A, char C) {//执行最大盘子的从A-C的移动
        System.out.println("move:" + A + "--->" + C);
    }

    public static void main(String[] args) {
        hanoi hanoi = new hanoi();
        System.out.println("移动汉诺塔的步骤：");
        hanoi.hanoi(4, 'a', 'b', 'c','d',4);
    }
}



