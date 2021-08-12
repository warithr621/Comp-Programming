//Problem: https://codeforces.com/contest/1117/problem/A

import java.io.*;
import java.util.*;

public class best_subseg {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next());
            int mx = -1, ans = 0, cur = -1, len = 0;
            while(n-->0) {
                int temp = Integer.parseInt(next());
                if (cur != temp) {
                    cur = temp; len = 0;
                }
                ++len;
                if (mx < cur) {
                    mx = cur; ans = 0;
                }
                if (mx == cur) {
                    ans = Math.max(ans, len);
                }
            }
            out.println(ans);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
