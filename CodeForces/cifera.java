//Problem: https://codeforces.com/contest/114/problem/A

import java.io.*;
import java.util.*;

public class cifera {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            long N = Long.parseLong(next()), L = Long.parseLong(next());
            double D = Math.log(L) * 1.0 / Math.log(N);
            out.println(Math.pow(N, Math.floor(D) * 1L) == L ? "YES\n" + (int) --D : "NO");
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
