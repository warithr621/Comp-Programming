//Problem: https://atcoder.jp/contests/arc117/tasks/arc117_b

import java.io.*;
import java.util.*;

public class wreck {
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
		    int[] a = new int[n+1];
		    for (int i = 1; i <= n; i++) a[i] = nexti();
		    a[0] = 0; Arrays.sort(a);
		    long ans = 1;
		    for (int i = 1; i <= n; i++) {
		        ans *= (a[i] - a[i-1] + 1L);
		        ans %= 1000000007;
		    }
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
