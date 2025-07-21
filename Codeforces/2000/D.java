// https://codeforces.com/contest/2000/problem/D

import java.util.*;

public class RightLeftWrong {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) A[i] = sc.nextInt();
            long[] P = new long[N+1];
            for (int i = 1; i <= N; i++) P[i] = P[i-1] + A[i-1];
            char[] C = sc.next().toCharArray();
            long ans = 0;
            int L = 0, R = N-1;
            while (L < R) {
                while (L < N && C[L] != 'L') ++L;
                while (R >= 0 && C[R] != 'R') --R;
                if (L < R && C[L] == 'L' && C[R] == 'R') ans += P[R+1] - P[L];
                ++L;
                --R;
            }
            System.out.println(ans);
        }
    }
}