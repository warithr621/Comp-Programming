//Problem: https://codeforces.com/contest/810/problem/A

import java.io.*;
import java.util.*;

public class Straight_a {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next()), k = Integer.parseInt(next());
            int sum = 0;
            for (int i = 0; i < n; i++) sum += Integer.parseInt(next());
            int ans = 0;
            while(sum * 1.0 / n < k - 0.5) {sum += k; ++ans; ++n;}
            out.println(ans);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
