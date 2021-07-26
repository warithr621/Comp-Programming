//Problem: https://codeforces.com/contest/985/problem/A

import java.io.*;
import java.util.*;

public class chess {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = nexti();
        for (int ttt = 1; ttt <= T; ttt++) {
            int n = nexti();
            int one = 0, two = 0;
            int[] a = new int[n/2];
            for (int i = 0; i < n/2; i++) a[i] = nexti();
            for (int i = 0; i < n/2; i++) {
                one += Math.abs(a[i] - i * 2 - 1);
                two += Math.abs(a[i] - i*2 - 2);
            }
            out.println((int) Math.min(one, two));
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
