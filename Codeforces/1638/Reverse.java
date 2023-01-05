// https://codeforces.com/problemset/problem/1638/A

import java.util.*;
import java.io.*;

public class Reverse {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out;
    
    public static int[] swap(int[] a, int l, int r) {
        while(l < r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            ++l; --r;
        }
        return a;
    }
    
    public static void solve() throws IOException {
        int N = sc.nextInt();
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) P[i] = sc.nextInt();
        
        int bad = 1;
        while(bad <= N && P[bad] == bad) ++bad;
        if (bad <= N) {
            int find = bad+1;
            while(P[find] != bad) ++find;
            P = swap(P, bad, find);
        }
        
        for (int i = 1; i <= N; i++) out.print(P[i] + " ");
        out.println();
    }
    
    public static void main(String[] args) throws IOException {
        out = new PrintWriter(System.out);
        int T = sc.nextInt();
        while(T-->0) solve();
        out.close();
    }
}