//Problem 8

import java.io.*;
import java.util.*;
 
public class Leonardo {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("leonardo.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] t = s.split(" = ");
		        for (int i = 0; i < t[0].length(); i++) {
		            char c = t[0].charAt(i);
		            if ('A' <= c && c <= 'Z') out.print(c);
		        }
		        out.print(" = ");
		        String[] temp = t[1].split(" ");
		        for (String str : temp) out.print((char) (str.charAt(str.length()-1) - 32));
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
