//Problem: https://codeforces.com/contest/1335/problem/C

import java.io.*;
import java.util.*;

public class two_team_compose {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("main.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int n = nexti();
		    int[] a = new int[n+2];
		    Arrays.fill(a, 0);
		    for (int i = 0; i < n; i++) a[nexti()]++;
		    int mx = 0, diff = 0;
		    for (int i = 0; i < n+2; i++) {
		        if (a[i] > 0) ++diff;
		        mx = Math.max(a[i], mx);
		    }
		    out.println(Math.max(Math.min(mx, diff-1), Math.min(mx-1, diff)));
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
