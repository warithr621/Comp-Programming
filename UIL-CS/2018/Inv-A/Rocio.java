//Problem 9

import java.io.*;
import java.util.*;

public class Rocio {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("rocio.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        st = new StringTokenizer(s);
		        int a = nexti(), b = nexti();
		        for (int i = 0; i < b; i++) {
		            for (int j = 0; j < i; j++) out.print(' ');
		            out.print('*');
		            for (int j = 0; j < a - 2 - 2*i; j++) out.print(' ');
		            out.println('*');
		        }
		        for (int i = 0; i < a - 2*b; i++) {
		            for (int j =0; j < b; j++) out.print(' ');
		            for (int j = 0; j < a - 2*b; j++) out.print('*');
		            out.println();
		        }
		        for (int i = b-1; i >= 0; i--) {
		            for (int j = 0; j < i; j++) out.print(' ');
		            out.print('*');
		            for (int j = 0; j < a-2-2*i; j++) out.print(' ');
		            out.println('*');
		        }
		        for (int i = 0; i < a; i++) out.print('=');
		        out.println();
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