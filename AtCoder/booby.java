//Problem: https://atcoder.jp/contests/abc213/tasks/abc213_b

import java.io.*;
import java.util.*;

public class Main {
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
		    TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		    for (int i = 1; i <= n; i++) tm.put(nexti(), i);
		    int x = 1;
		    for (int i : tm.keySet()) {
		        if (x != n-1) {
		            ++x;
		        } else {
		            out.println(tm.get(i));
		            break;
		        }
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
}
