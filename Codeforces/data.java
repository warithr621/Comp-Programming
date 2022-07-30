//Problem: https://codeforces.com/contest/1250/problem/F

import java.io.*;
import java.util.*;

public class data {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = next(1);
        for (int t = 1; t <= T; t++) {
            int n = next(1);
            int ans = Integer.MAX_VALUE;
            for (int i = (int) Math.sqrt(n); i >= 1; i--) {
                if (n % i == 0) ans = Math.min(ans, 2 * (i + n/i));
            }
            out.println(ans);
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
