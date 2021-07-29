//Problem 8

import java.io.*;
import java.util.*;

public class Prashant {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("prashant.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] t = s.split(" ");
		        int[] c = new int[26];
		        Arrays.fill(c, 0);
		        for (String x : t) c[x.charAt(0) - 'A']++;
		        long ans = factorial(t.length);
		        for (int i : c) if (i > 1) ans /= factorial(i);
		        out.println(ans);
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
    static long factorial(long n) {
        if (n <= 1L) return 1L;
        return n * 1L * factorial(n-1L);
    }
}
