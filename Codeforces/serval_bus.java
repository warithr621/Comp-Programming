//Problem: https://codeforces.com/contest/1153/problem/A

import java.io.*;
import java.util.*;

public class serval_bus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = next(1);
        for (int ttt = 1; ttt <= T; ttt++) {
            int n = next(1), t = next(1);
            int best = Integer.MAX_VALUE, ans = 0;
            for (int i = 1; i <= n; i++) {
                int s = next(1), d = next(1);
                int check = s > t ? s : (int) Math.ceil((t-s) * 1.0 /d)*d+s;
                if (check < best) {
                    ans = i; best = check;
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
    static int next(int x) throws IOException {
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
}
