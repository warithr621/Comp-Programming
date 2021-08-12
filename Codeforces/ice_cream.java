//Problem: https://codeforces.com/contest/686/problem/A

import java.io.*;
import java.util.*;

public class ice_cream {
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
		    long n = nextl(), sum = nextl(), ans = 0;
		    while(n-->0) {
		        String s = next();
		        long t = nextl();
		        if (s.equals("+")) sum += t;
		        else {
		            if (t > sum) ++ans;
		            else sum -= t;
		        }
		    }
		    out.printf("%d %d", sum, ans);
		}
		br.close(); out.close();
	}
	static void swap(int[] a, int L, int R) {
	    int temp = a[L];
	    a[L] = a[R];
	    a[R] = temp;
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
