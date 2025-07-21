//Problem: https://codeforces.com/contest/174/problem/A

import java.io.*;
import java.util.*;

public class equation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next()), k = Integer.parseInt(next()), mx = -1;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(next());
                mx = Math.max(a[i], mx);
            }
            int thinkies = k;
            for (int i : a) thinkies -= mx - i;
            if (thinkies < 0) out.println(-1);
            else {
                for (int i : a) out.printf("%.6f%n", thinkies * 1.0 / n + mx - i);
            }
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
