//Problem 4

import java.io.*;
import java.util.*;

public class Dasha {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("dasha.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int a = nexti(), b = nexti(), m = nexti();
		    ArrayList<Integer> al = new ArrayList<Integer>();
		    al.add(nexti());
		    int i = 0;
		    while (true) {
		        int x_0 = (a * al.get(i) + b) % m;
		        if (al.contains(x_0)) break;
		        al.add(x_0);
		        ++i;
		    }
		    out.printf("%d / %d%n", ++i, m);
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
