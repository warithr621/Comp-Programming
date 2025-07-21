//Problem: https://codeforces.com/contest/900/problem/A

import java.io.*;
import java.util.*;

public class extra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = next(1);
        for (int t = 1; t <= T; t++) {
            int n = next(1);
            int neg = 0, pos = 0;
            while(n-->0) {
                if (next(1) < 0) ++neg;
                else ++pos;
                next();
            }
            out.println(neg<=1 || pos<=1 ? "Yes" : "No");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int next(int x) throws IOException {
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
}