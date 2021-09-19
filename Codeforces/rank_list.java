//Problem: https://codeforces.com/contest/166/problem/A

import java.io.*;
import java.util.*;

public class rank_list {
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
		    int n = nexti(), k = nexti();--k;
		    ArrayList<Place> al = new ArrayList<Place>();
		    for (int i = 0; i < n; i++) {
		        Place p = new Place(nexti(), nexti());
		        al.add(p);
		    }
		    Collections.sort(al);
		    int ans = 0;
		    for (int i = 0; i < n; i++) ans = (al.get(i).same(al.get(k)) ? ++ans : ans);
		    out.println(ans);
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
class Place implements Comparable<Place> {
    int p, t;
    public Place(int p, int t) {
        this.p = p;
        this.t = t;
    }
    public String toString() {
        return p + " " + t;
    }
    public int compareTo(Place p) {
        if (this.p > p.p) return -1;
        if (this.p < p.p) return 1;
        if (this.t == p.t) return 0;
        return (this.t < p.t ? -1 : 1);
    }
    public boolean same(Place p) {
        return this.p == p.p && p.t == this.t;
    }
}
