//Problem: https://codeforces.com/contest/548/problem/A

import java.io.*;
import java.util.*;

public class mike_and_fax {
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
		    String s = next();
		    int k = nexti();
		    boolean b = true;
		    if (s.length() % k != 0) {
		        out.println("NO");
		        b = false; break;
		    }
		    int L = s.length() / k;
		    int i = 0;
		    while(b == true && i < s.length()) {
		        if (!pal(s.substring(i, i + L))) {
		            out.println("NO");
		            b = false;
		        }
		        i += L;
		    }
		    if (b) out.println("YES");
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
    static boolean pal(String s) {
        for (int i = 0; i <= s.length() / 2; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
}
