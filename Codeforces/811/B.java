//Problem: https://codeforces.com/contest/811/problem/B

import java.io.*;
import java.util.*;

public class vlad_book {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = nexti();
        for (int tt = 1; tt <= T; tt++) {
            int n = nexti(), m = nexti();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = nexti();
            while(m-->0) {
                int L = nexti(), R = nexti(), x = nexti();
                int cnt = 0;
                for (int i = L-1; i < R; i++) if (a[i] < a[x-1]) ++cnt;
                out.println(cnt + L == x ? "Yes" : "No");
            }
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
}
