//Problem 11

import java.io.*;
import java.util.*;

public class Vicente {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("vicente.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s;
		    while((s = br.readLine()) != null) {
		        st = new StringTokenizer(s);
		        String ham = next();
		        out.print(Long.toString(Long.parseLong(ham, 2), 16).toUpperCase() + ' ');
		        int par = next().equals("EVEN") ? 0 : 1;
		        int sum = 0;
		        for (int i = 0; i < ham.length(); i++) sum += ham.charAt(i) - '0';
		        ham += sum % 2 == par ? '0' : '1';
		        out.println(Long.toString(Long.parseLong(ham, 2), 16).toUpperCase());
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