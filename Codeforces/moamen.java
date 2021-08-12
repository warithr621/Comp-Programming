//Problem: https://codeforces.com/contest/1557/problem/B

import java.io.*;
import java.util.*;

public class moamen {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("main.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    int n = nexti(), k = nexti();
		    TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		    for (int i = 0; i < n; i++) tm.put(nexti(), i);
		    int arr[] = new int[tm.keySet().size()]; int q = 0;
		    for (int x : tm.keySet()) arr[q++] = x;
		    int ans = 1;
		    for (int i = 1; i < n; i++) if (tm.get(arr[i]) - 1 != tm.get(arr[i-1])) ++ans;
		    out.println(ans <= k ? "YES" : "NO");
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
