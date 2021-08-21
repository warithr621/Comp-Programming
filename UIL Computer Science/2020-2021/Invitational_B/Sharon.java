//Problem 11

import java.io.*;
import java.util.*;

public class Sharon {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	   // br = new BufferedReader(new InputStreamReader(System.in));
	    br = new BufferedReader(new FileReader("sharon.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int c = nexti(), p = nexti();
		    int cur = 0;
		    ArrayList<String> al = new ArrayList<String>();
		    for (int i = 0; i < p; i++) al.add(next());
		    while(al.size() != 1) {
		        cur = (cur + c + p - 1) % p;
		        if (cur == al.size()) cur = 0;
		        al.remove(cur); --p;
		    }
		    out.println("The winner is " + al.get(0));
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
