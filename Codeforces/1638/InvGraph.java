// https://codeforces.com/problemset/problem/1638/C

import java.util.*;
public class InvGraph {
    static Scanner sc = new Scanner(System.in);
    
    public static void solve() {
        int N = sc.nextInt();
        int cur = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            cur = Math.max(cur, X);
            if (cur == i+1) ++ans;
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        int T = sc.nextInt();
        while(T-->0) solve();
    }
}