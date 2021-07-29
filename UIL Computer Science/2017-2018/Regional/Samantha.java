//Problem 10

import java.io.*;
import java.util.*;

public class Samantha {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("samantha.in"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] t = s.split(" ");
		        double sub = 0;
		        for (String x : t) sub += Double.parseDouble(x);
		        double tax = round(sub * 0.0825);
		        out.printf("Subtotal: $%7.2f%nTax     : $%7.2f%nTotal   : $%7.2f%n=====%n", sub, tax, sub + tax);
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
    static double round(double d) {
        return Math.floor(d * 100.0) / 100.0;
    }
}
