//Problem: https://codeforces.com/contest/1059/problem/A

import java.io.*;
import java.util.*;

public class cashier {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int x = 1; x <= T; x++) {
            int n = Integer.parseInt(next()), L = Integer.parseInt(next()), a = Integer.parseInt(next());
            int start = 0, ans = 0, t, l;
            while(n-->0) {
                t = Integer.parseInt(next()); l = Integer.parseInt(next());
                ans += (t - start) / a;
                start = t + l;
            }
            out.println(ans + (L - start)/a);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
