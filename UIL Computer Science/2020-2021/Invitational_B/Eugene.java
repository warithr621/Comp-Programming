//Problem 4

import java.io.*;
import java.util.*;

public class Eugene {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("eugene.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int n = nexti();
		    HashMap<String, String> hm = new HashMap<String, String>();
		    while(n-->0) {
		        String first = next(), last = next();
		        out.print(first + " " + last + " ");
		        String[] user = {Character.toString(first.charAt(0) + 32), Character.toString(last.charAt(0) + 32), Integer.toString((int) first.charAt(0)), Integer.toString((int) last.charAt(0))};
		        while(hm.containsValue(user[0] + user[1] + user[2] + user[3])) user[2] = Integer.toString(Integer.parseInt(user[2]) + 1);
		        hm.put((String) (first + " " + last), user[0] + user[1] + user[2] + user[3]);
		        out.print(hm.get(first + " " + last) + "\n");
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
