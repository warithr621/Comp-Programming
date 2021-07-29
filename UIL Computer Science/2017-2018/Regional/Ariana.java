//Problem 1

import java.io.*;
import java.util.*;

public class Ariana {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("ariana.in"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String[] list = {"I must not tell lies.", "i MUST not tell lies.", "i must NOT tell lies.", "i must not TELL lies.",
		    "i must not tell LIES.", "i must not TELL lies.", "i must NOT tell lies.", "i MUST not tell lies."};
		    for (int i = 0; i < 40; i++) out.printf("%-2d %s%n", i+1, list[i%8]);
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
