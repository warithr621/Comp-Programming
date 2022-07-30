//Problem: https://codeforces.com/contest/1204/problem/A

import java.io.*;
import java.util.*;

public class bow_wow_timetable {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("main.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s = next();
		    int o = 0, l = s.length();
		    for (int i =0 ; i < l; i++) o = s.charAt(i) == 49 ? ++o : o;
		    if (s.equals("0")) out.println(0);
		    else
		        out.println((l + 1 - (o == 1 ? 1 : 0)) / 2);
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
