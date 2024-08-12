// https://codeforces.com/contest/1999/problem/G1

import java.util.*;

public class RulerEasy {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            int L = 1, R = 1000;
            while (L < R) {
                int M = (L + R) / 2;
                System.out.println("? 1 " + M);
                System.out.flush();
                int A = sc.nextInt();
                if (A > M) {
                    R = M;
                } else {
                    L = M + 1;
                }
            }
            System.out.println("! " + L);
            System.out.flush();
        }
    }
}