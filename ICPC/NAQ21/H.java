// 2021 NAQ: Mult!

import java.util.*;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int small = -1;
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            if (small == -1) small = X;
            else if (X % small == 0) {
                System.out.println(X);
                small = -1;
            }
        }
    }
}