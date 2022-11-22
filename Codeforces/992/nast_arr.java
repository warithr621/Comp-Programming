//Problem: https://codeforces.com/contest/992/problem/A

import java.io.*;
import java.util.*;

public class nast_arr {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = next(1);
        for (int t = 1; t <= T; t++) {
            int n = next(1);
            int[] a = new int[n];
            TreeSet<Integer> ts = new TreeSet<Integer>();
            while(n-->0) {
                int x = next(1); if (x != 0) ts.add(x);
            }
            out.println(ts.size());
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