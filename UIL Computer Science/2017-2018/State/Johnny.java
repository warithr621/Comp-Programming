//Problem 6

import java.io.*;
import java.util.*;

public class Johnny {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("johnny.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    HashMap<String, Character> hm = new HashMap<String, Character>();
		    String s;
		    while((s = br.readLine()) != null) {
		        String[] t = s.split(" ");
		        if (t.length == 2) {
		            String[] lol = t[1].split("/");
		            for (String str : lol) hm.put(str, t[0].charAt(0));
		        } else {
		            for (String str : t) out.print(hm.get(str));
		            out.println();
		        }
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
