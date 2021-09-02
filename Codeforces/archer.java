//Problem: https://codeforces.com/problemset/problem/312/B

import java.io.*;
import java.util.*;

public class archer {
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
		    double a = nextd(), b = nextd(), c = nextd(), d = nextd();
		    double ans = a / b;
		    double bel = 1 - (b-a) * (d-c) / b / d;
		    ans /= bel;
		    out.printf("%.8f", ans);
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
