//Problem: https://atcoder.jp/contests/abc207/tasks/abc207_a

import java.io.*;
import java.util.*;

public class Repression {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int[] a = new int[3];
            for (int i = 0; i < 3; i++) a[i] = Integer.parseInt(next());
            Arrays.sort(a);
            out.println(a[1] + a[2]);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
