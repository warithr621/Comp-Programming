//Problem 10

import java.io.*;
import java.util.*;

public class Paaus {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("paaus.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int n = nexti(); String k = next();
		    String ans = "1234567890qwertyuiopasdfghjklzxcvbnm,wertyhj45rytfuxyu6cc3verb6tv7ujyt3xcfergt8v6bgx2w";
		    String two = Integer.toString(n, 2), eight = Integer.toString(n, 8), ten = Integer.toString(n, 10), sixteen = Integer.toString(n, 16);
		    two = "0b" + two;
		    eight = "0" + eight;
		    sixteen = "0x" + sixteen;
		    if (!two.contains(k) && two.length() < ans.length()) ans = two;
		    if (!eight.contains(k) && eight.length() < ans.length()) ans = eight;
		    if (!ten.contains(k) && ten.length() < ans.length()) ans = ten;
		    if (!sixteen.contains(k) && sixteen.length() < ans.length()) ans = sixteen;
		    out.printf("Case #%d: %s%n", tt, ans.equals("1234567890qwertyuiopasdfghjklzxcvbnm,wertyhj45rytfuxyu6cc3verb6tv7ujyt3xcfergt8v6bgx2w") ? "Impossible" : ans);
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
