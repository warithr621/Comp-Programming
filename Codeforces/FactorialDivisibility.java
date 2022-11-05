// https://codeforces.com/problemset/problem/1753/B

import java.util.*;

public class FactorDivisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        
        int[] a = new int[x+1];
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            a[Math.min(in, x)]++;
        }
        
        for (int i = 1; i < x; ++i) {
            if (a[i] % (i+1) != 0) {
                System.out.println("NO");
                return;
            }
            
            a[i+1] += a[i] / (i+1);
        }
        
        System.out.println("YES");
    }
}