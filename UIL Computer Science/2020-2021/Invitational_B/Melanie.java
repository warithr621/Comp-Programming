//Problem 9

import java.io.*;
import java.util.*;

public class Melanie {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("melanie.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		int[] S = new int[26], L = new int[26];
		for (int tt = 1; tt <= T; tt++) {
		    Arrays.fill(S, 0); Arrays.fill(L, 0);
		    String s = next();
		    for (int i = 0; i < s.length(); i++) {
		        if (s.charAt(i) >= 97) S[s.charAt(i) - 97]++;
		        else L[s.charAt(i) - 65]++;
		    }
		    long ans = fact(s.length() * 1L);
		    for (int i : S) ans /= fact(i * 1L);
		    for (int i : L) ans /= fact(i * 1L);
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
    static long fact(long n) {
        if (n <= 1) return 1L;
        return n * fact(--n);
    }
}
