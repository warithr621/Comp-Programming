//Problem 5

import java.io.*;
import java.util.*;

public class Hannah {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("hannah.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int b = nexti();
		    String F = next(), op = next(), S = next();
		    out.printf("%s %s %s = ", F, op, S);
		    int FF = Integer.parseInt(F, b), SS = Integer.parseInt(S, b);
		    int ans = op.equals("+") ? FF + SS : op.equals("-") ? FF - SS : op.equals("*") ? FF * SS : FF / SS;
		    out.println(Integer.toString(ans, b).toUpperCase());
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
