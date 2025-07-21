// https://codeforces.com/contest/977/problem/B
// Virtual

import java.io.*;
import java.util.*;

public class TwoGram {
	static int T = 1;
	static FastIO out;
	static String next() throws IOException {return out.next();}
	static int nexti() throws IOException {return out.nextInt();}
	static long nextl() throws IOException {return out.nextLong();}
	static double nextd() throws IOException {return out.nextDouble();}
	
	public static void main(String[] args) throws IOException {
	    out = new FastIO();
// 		T = nexti();
		while(T-->0) solve();
		out.close();
	}
	
	public static void solve() throws IOException {
	    //solve
	    int n = nexti(); String s = next();
	    HashMap<String, Integer> hm = new HashMap<String, Integer>();
	    for (int i = 0; i < n-1;  i++) {
	        String str = s.substring(i, i+2);
	        if (hm.containsKey(str)) hm.put(str, hm.get(str)+1);
	        else hm.put(str, 1);
	    }
	    String ans = "";
	    int max = -1;
	    for (String str : hm.keySet()) {
	        if (hm.get(str) > max) {
	            max = hm.get(str);
	            ans = str;
	        }
	    }
	    out.println(ans);
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
    public int nextInt() {
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
    public long nextLong() {
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
    public double nextDouble() { return Double.parseDouble(next()); }
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