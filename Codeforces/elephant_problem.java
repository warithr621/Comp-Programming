//Problem: https://codeforces.com/problemset/problem/220/A

import java.io.*;
import java.util.*;

public class elephant_problem {
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
		    int n = nexti(), sum = 0;
                    int[] a = new int[n], b = new int[n];
                    for (int i = 0; i < n; i++) {
                        a[i] = nexti(); b[i] = a[i];
                    }
                    Arrays.sort(b);
                    for (int i = 0; i < n; i++) if (a[i] != b[i]) ++sum;
		    out.println(sum <= 2 ? "YES" : "NO");
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
