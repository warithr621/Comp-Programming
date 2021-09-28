//Problem: https://atcoder.jp/contests/abc220/tasks/abc220_c

import java.io.*;
import java.util.*;

public class long_seq {
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
		    long n = nextl();
		    long[] a = new long[(int)n];
		    long sum = 0;
		    for (int i = 0; i < (int)n; i++) sum += a[i] = nextl();
		    long x = nextl();
		    long S = x / sum * sum;
		    long ans = x / sum * n;
		    for (long i : a) {
		        S += i;
		        ++ans;
		        if (S > x) {
		            out.println(ans);
		            break;
		        }
		    }
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
