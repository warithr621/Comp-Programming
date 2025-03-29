import java.util.*;

public class D2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] A = new int[N], B = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < N; i++) B[i] = sc.nextInt();
        long L = 0, R = 2_000_000_000;
        while (L < R) {
            long M = (L + R + 1) / 2;
            long needed = 0;
            for (int i = 0; i < N; i++) {
                needed += Math.max(0, A[i] * M - B[i]);
                if (needed > K) break;
            }
            if (K >= needed) L = M;
            else R = --M;
        }
        System.out.println(L);
    }
}