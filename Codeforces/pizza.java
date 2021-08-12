//Problem: https://codeforces.com/contest/979/problem/A

import java.io.*;
import java.util.*;

public class pizza {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = nexti();
        for (int tt = 1; tt <= T; tt++) {
            long x = nextl();
            ++x;
            if (x == 1) out.println(0);
            else out.println(x % 2 == 0 ? x/2 : x);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nexti() throws IOException {
        return Integer.parseInt(next());
    }
    static long nextl() throws IOException {
        return Long.parseLong(next());
    }
}
