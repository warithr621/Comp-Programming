// https://codeforces.com/contest/1996/problem/C

import java.util.*;

public class Sort {
    
    static void solve(Scanner sc) {
        int N = sc.nextInt(), Q = sc.nextInt();
        char[] A = sc.next().toCharArray(), B = sc.next().toCharArray();
        int[][][] pfx = new int[2][26][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 26; j++) {
                pfx[0][j][i+1] = pfx[0][j][i] + (A[i] - 'a' == j ? 1 : 0);
                pfx[1][j][i+1] = pfx[1][j][i] + (B[i] - 'a' == j ? 1 : 0);
            }
        }
        
        while (Q --> 0) {
            int L = sc.nextInt(), R = sc.nextInt();
            int ans = 0;
            for (int j = 0; j < 26; j++) {
                int fst = pfx[0][j][R] - pfx[0][j][L-1];
                int sec = pfx[1][j][R] - pfx[1][j][L-1];
                // System.out.println(fst + " " + sec);
                ans += Math.abs(fst - sec);
            }
            System.out.println(ans >> 1);
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) solve(sc);
    }
}