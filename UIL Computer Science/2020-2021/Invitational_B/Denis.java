//Problem 3

import java.io.*;
import java.util.*;

public class Denis {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("denis.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    st = new StringTokenizer(br.readLine(), "/");
		    int a = nexti(), b = nexti();
		    out.printf("%d/%d reduced is ", a, b);
		    boolean neg = a < 0 ^ b < 0;
		    a = Math.abs(a); b = Math.abs(b);
		    int g = gcd(a, b);
		    out.printf("%s%d/%d%n", neg ? "-" : "", a/g, b/g);
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
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
