//Problem: https://codeforces.com/contest/629/problem/B

import java.io.*;
import java.util.*;

public class far_relative {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("main.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int n = nexti();
		    int[] m = new int[366], f = new int[366];
		    Arrays.fill(m, 0); Arrays.fill(f, 0);
		    while (n-->0) {
		        char c = next().charAt(0);
		        int L = nexti(), R = nexti();
		        if (c == 'F') for (int i = L-1; i < R; i++) ++f[i];
		        else for (int i = L-1; i < R; i++) ++m[i];
		    }
		    int ans = 0;
		    for (int i = 0; i < 366; i++) ans = Math.max(ans, 2 * Math.min(m[i], f[i]));
		    out.println(ans);
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
    static long nextl() throws IOException {
        return Long.parseLong(next());
    }
    static double nextd() throws IOException {
        return Double.parseDouble(next());
    }
}
