//Problem: https://codeforces.com/contest/981/problem/B

import java.io.*;
import java.util.*;

public class Main {
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
		    int n = nexti();
		    HashMap<Long, Long> hm = new HashMap<Long, Long>();
		    while(n-->0) {
		        long x = nextl(), y = nextl();
		        if (hm.containsKey(x)) {
		            if (hm.get(x) < y) hm.put(x,y);
		        } else hm.put(x,y);
		    }
		    int m = nexti();
		    while(m-->0) {
		        long x = nextl(), y = nextl();
		        if (hm.containsKey(x)) {
		            if (hm.get(x) < y) hm.put(x,y);
		        } else hm.put(x,y);
		    }
		    long sum = 0;
		    for (long i : hm.keySet()) sum += hm.get(i);
		    out.println(sum);
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
