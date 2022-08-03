//Problem 8

import java.io.*;
import java.util.*;

public class Polina {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("polina.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String temp;
		    while((temp = br.readLine()) != null) {
		        st = new StringTokenizer(temp);
		        String s = next(), F = "", L = "";
		        out.print(s + " ");
		        char[] O = s.toCharArray();
		        int thonk = 0;
		        while(st.hasMoreTokens()) {
		            String code = next();
		            String hex = Integer.toString(Integer.parseInt(code), 16).toUpperCase();
		            if (code.charAt(0) % 2 == 0) swap(O, code.charAt(1) - '0' - 1, code.charAt(2) - '0' - 1);
		            else swap(O, O.length - code.charAt(1) + '0', O.length - code.charAt(2) + '0');
		            char[] x;
		            if (thonk == 0) {
		                x = new char[O.length+5];
		                x[0] = hex.charAt(0); x[1] = 'A'; x[x.length-3] = x[1]; x[x.length-2] = x[1];
        	            x[x.length-1] = hex.charAt(2);
        	            for (int i = 0; i < O.length; i++) x[i+2] = O[i];
		            } else {
		                x = new char[O.length+2];
		                x[0] = hex.charAt(0); x[x.length-1] = hex.charAt(2);
		                for (int i = 0; i < O.length; i++) x[i+1] = O[i];
		            }
		            O = x;
		            
		            ++thonk;
		        }
		        for (char c : O) out.print(c);
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
    static double round(double d) {
        return Math.round(d * 100.0) / 100.0;
    }
    static void swap(char[] c, int L, int R) {
        char temp = c[L];
        c[L] = c[R];
        c[R] = temp;
    }
}