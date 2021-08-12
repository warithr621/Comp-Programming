//Problem: https://codeforces.com/contest/686/problem/B

import java.io.*;
import java.util.*;

public class rob_zoo {
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
		    int[] a = new int[n];
		    for (int i = 0; i < n; i++) a[i] = nexti();
		    for (int i = n-1; i > 0; i--) {
		        for (int j = 0; j < i; j++) {
		            if (a[j] > a[j+1]) {
		                swap(a, j, j+1);
		                out.printf("%d %d%n", j+1, j+2);
		            }
		        }
		    }
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
