// CSES Missing Number

import java.io.*;
import java.util.*;
 
public class MissNum {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("main.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // out = new PrintWriter(new BufferedWriter(new FileWriter("main.out")));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int x = nexti();
		    long ans = x * (x+1L) / 2L;
		    for (int i = 0; i < x-1; i++) ans -= nextl();
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