//Problem 12

import java.io.*;
import java.util.*;

public class Wally {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("wally.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s = next();
		    ArrayList<String> W = new ArrayList<String>(), ans = new ArrayList<String>();
		    while(!s.equals("999")) {
		        W.add(s);
		        s = next();
		    }
		    while((s = br.readLine()) != null) {
		        if (W.contains(s)) continue;
		        if ('0' <= s.charAt(0) && s.charAt(0) <= '9') continue;
		        if (s.equals("true") || s.equals("false") || s.equals("null")) continue;
		        if (s.matches(".*[^A-z a-z \\d _ $].*")) continue;
		        if (s.matches(".*(\\s).*")) continue;
		        ans.add(s);
		    }
		    Collections.sort(ans);
		    for (String str : ans) out.println(str);
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