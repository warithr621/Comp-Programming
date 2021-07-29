//Problem 3

import java.io.*;
import java.util.*;

public class Dennis {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("dennis.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int n = nexti();
		    String[] list = new String[n];
		    int mx = 0;
		    for (int i = 0; i < n; i++) {
		        list[i] = next();
		        mx = Math.max(mx, list[i].length());
		    }
		    char[][] mat = new char[mx][n];
		    for (int i = 0; i < mx; i++) Arrays.fill(mat[i], ' ');
		    for (int i = 0; i < n; i++) {
		        for (int j = 0; j < list[i].length(); j++) mat[j][i] = list[i].charAt(j);
		    }
		    for (char[] arr : mat) {
		        for (char c : arr) out.print(c);
		        out.println();
		    }
		    for (int i = 0; i < n; i++) out.print("*");
		    out.println();
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
