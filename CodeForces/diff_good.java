//Problem: https://codeforces.com/contest/672/problem/B

import java.io.*;
import java.util.*;

public class diff_good {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = next(1);
        for (int t = 1; t <= T; t++) {
            int n = next(1);
            if (n > 26) out.println(-1);
            else {
                HashSet<Character> hs = new HashSet<Character>();
                String s = next();
                for (int i = 0; i < n; i++) hs.add(s.charAt(i));
                out.println(n - hs.size());
            }
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
