// CSES Nim Game II

import java.util.*;

public class NimGameII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            // if we do everything mod 4, the problem reduces to game I
            int N = sc.nextInt(), ans = 0;
            while (N --> 0) ans ^= (sc.nextInt() % 4);
            System.out.println(ans != 0 ? "first" : "second");
        }
    }
}