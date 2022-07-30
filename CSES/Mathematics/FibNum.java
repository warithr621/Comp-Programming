// CSES Fibonacci Numbers

import java.io.*;
import java.util.*;

public class FibNum {
	static FastIO out;
	static long nextl() throws IOException {return out.nextLong();}
	
	public static void main(String[] args) throws IOException {
	    out = new FastIO();
		solve();
		out.close();
	}
	
	static long[][] mult(long[][] a, long[][] b) {
	    long[][] ans = {{0, 0}, {0, 0}};
	    for (int i = 0; i < 2; i++) {
	        for (int j = 0; j < 2; j++) {
	            for (int k = 0; k < 2; k++) {
	                ans[i][j] += a[i][k] * b[k][j];
	                ans[i][j] %= 1000000007;
	            }
	        }
	    }
	    return ans;
	}
	
	public static void solve() throws IOException {
	    //solve
	    long n = nextl();
	    long[][] m = {{1, 1}, {1, 0}}, init = {{1, 0}, {0, 1}};
	    for (; n > 0; n /= 2) {
	        if ((n & 1) > 0) init = mult(init, m);
	        m = mult(m, m);
	    }
	    out.println(init[0][1]);
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
