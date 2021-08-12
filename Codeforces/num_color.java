//Problem: https://codeforces.com/contest/1245/problem/A

import java.util.*;

public class num_color {
    static int gcd (int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            int a = s.nextInt(), b = s.nextInt();
            System.out.println(gcd(a,b) == 1 ? "Finite" : "Infinite");
        }
    }
}
