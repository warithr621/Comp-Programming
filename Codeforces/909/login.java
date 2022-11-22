//Problem: https://codeforces.com/contest/909/problem/A

import java.io.*;
import java.util.*;

public class login {
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
		    String f = next(), l = next();
		    char last = l.charAt(0);
		    out.print(f.charAt(0));
		    int i = 1;
		    while(i < f.length() && f.charAt(i) < l.charAt(0)) {
		        out.print(f.charAt(i)); ++i;
		    }
		    out.println(l.charAt(0));
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
