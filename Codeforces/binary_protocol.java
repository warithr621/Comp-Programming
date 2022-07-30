//Problem: https://codeforces.com/contest/825/problem/A

import java.io.*;
import java.util.*;

public class binary_protocol {
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
		    String s = next();
		    int cnt = 0;
		    for (int i = 0; i < n; i++) {
		        if (s.charAt(i) == 49) ++cnt;
		        else {
		            out.print(cnt);
		            cnt = 0;
		        }
		    }
		    out.println(cnt);
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
