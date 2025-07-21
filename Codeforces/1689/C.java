// Problem: https://codeforces.com/problemset/problem/1689/C

import java.io.*;
import java.util.*;

public class InfectedTree {
	static int T = 1;
	static FastIO io;
	public static void main(String[] args) throws IOException {
	    io = new FastIO();
		T = io.nexti();
		while(T-->0) solve();
		io.close();
	}
	
	static int n;
	static ArrayList<Integer>[] adj;
	
	public static void solve() {
	    //solve
	    n = io.nexti();
	    adj = new ArrayList[n];
	    for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
	    for (int i = 1; i < n; i++) {
	        int a = io.nexti(), b = io.nexti();
	        --a; --b;
	        adj[a].add(b); adj[b].add(a);
	    }
	    io.println(n - dfs(0, -1));
	}
	static int dfs(int x, int p) {
	    int cnt = 0;
	    for (int c : adj[x]) {
	        if (c == p) continue;
	        ++cnt;
	    }
	    if (cnt <= 1) return ++cnt;
	    int mn = Integer.MAX_VALUE;
	    for (int c : adj[x]) {
	        if (c == p) continue;
	        mn = Math.min(mn, dfs(c, x));
	    }
	    return mn + 2;
	}
}

class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1<<16];
    private int curChar, numChars;
    // standard input
    public FastIO() { this(System.in,System.out); }
    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }
    // file input
    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }
    // throws InputMismatchException() if previously detected end of file
    private int nextByte() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) return -1; // end of file
        }
        return buf[curChar++];
    }
    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c; do { c = nextByte(); } while (c <= ' ');
        StringBuilder res = new StringBuilder();
        do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
        return res.toString();
    }
    public int nexti() {
        int c; do { c = nextByte(); } while (c <= ' ');
        int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10*res+c-'0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }
    public long nextl() {
        int c; do { c = nextByte(); } while (c <= ' ');
        int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10*res+c-'0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }
    public double nextd() { return Double.parseDouble(next()); }
}

class Pair implements Comparable<Pair> {
    int first, second;
    Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
    public String toString() {
        return first + " " + second;
    }
    public int compareTo(Pair p) {
        if (this.first > p.first) return 1;
        if (this.first < p.first) return -1;
        if (this.second > p.second) return 1;
        return -1;
    }
}