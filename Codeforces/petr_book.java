//Problem: https://codeforces.com/contest/139/problem/A

import java.io.*;
import java.util.*;

public class petr_book {
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
		    int[] a = new int[7];
		    for (int i = 0; i < 7; i++) a[i] = nexti();
		    int i = 0;
		    while(n > 0) {
		        n -= a[i];
		        i = ++i % 7;
		    }
		    out.println(i == 0 ? 7 : i);
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
