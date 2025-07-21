//Problem: https://codeforces.com/contest/1133/problem/A

import java.io.*;
import java.util.*;

public class mid_contest {
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
		    String[] a = next().split(":"), b = next().split(":");
		    int a1 = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
		    int b1 = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);
		    int ans = (a1 + b1) / 2;
		    out.printf("%02d:%02d", ans / 60, ans % 60);
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
