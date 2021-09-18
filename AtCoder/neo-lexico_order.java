//Problem: https://atcoder.jp/contests/abc219/tasks/abc219_c
//Note: Virtual Submission

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int T = 1;
	public static int X,Y;
	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   // br = new BufferedReader(new FileReader("main.dat"));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
// 		T = nexti();
		for (int tt = 1; tt <= T; tt++) {
		    String s = next();
		    int n = nexti();
		    ArrayList<Name> al = new ArrayList<Name>();
		    for (int i = 0; i < n; i++) {
		        Name N = new Name(next(), s);
		        al.add(N);
		    }
		    Collections.sort(al);
		    for (Name N : al) out.println(N);
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
class Name implements Comparable<Name> {
    String n, alpha;
    public Name(String n, String a) {
        this.n = n;
        this.alpha = a;
    }
    public int find(String s, char c) {
        for (int i = 0; i < 26; i++) if (s.charAt(i) == c) return i;
        return -1;
    }
    public int lexo(String a, String b) {
        for (int i = 0; i < (a.length() < b.length() ? a.length() : b.length()); i++) {
            int A = find(alpha, a.charAt(i));
            int B = find(alpha, b.charAt(i));
            if (A < B) return -1;
            if (A > B) return 1;
        }
        return a.length() < b.length() ? -1 : 1;
    }
    public int compareTo(Name n) {
        return lexo(this.n, n.n);
    }
    public String toString() {
        return n;
    }
}
