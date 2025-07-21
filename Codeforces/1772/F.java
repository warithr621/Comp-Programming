// https://codeforces.com/contest/1772/problem/F

import java.io.*;
import java.util.*;

public class CopyCopyCopy {
	static int T = 1;
	static FastIO out;
	static String next() throws IOException {return out.next();}
	static int nexti() throws IOException {return out.nextInt();}
	static long nextl() throws IOException {return out.nextLong();}
	static double nextd() throws IOException {return out.nextDouble();}
	
	public static void main(String[] args) throws IOException {
	    out = new FastIO();
		// T = nexti();
		while(T-->0) solve();
		out.close();
	}
	
	public static void solve() throws IOException {
	    //solve
	    int N = nexti(), M = nexti(), K = nexti();
        ArrayList<Picture> al = new ArrayList<>();
        for (int i = 1; i <= K+1; ++i) {
            Picture p = new Picture(i);
            for (int j = 0; j < N; ++j) p.add(next());
            al.add(p);
        }

        Collections.sort(al);
        // for (Picture p : al) out.println(p);
        out.println(al.get(0).idx);

        ArrayList<String> ops = new ArrayList<>();
        for (int i = 0; i < K; ++i) {
            // turn Picture i to Picture i+1
            for (int x = 0; x < N; ++x) {
                for (int y = 0; y < M; ++y) {
                    if (al.get(i).pic.get(x).charAt(y) != al.get(i+1).pic.get(x).charAt(y)) {
                        ops.add("1 " + (x+1) + " " + (y+1));
                    }
                }
            }
            ops.add("2 " + al.get(i+1).idx);
        }

        out.println(ops.size());
        for (String s : ops) out.println(s);
	}
}

class Picture implements Comparable<Picture> {
    ArrayList<String> pic;
    int idx;
    Picture(int x) {
        pic = new ArrayList<>();
        this.idx = x;
    }
    public void add(String s) {
        pic.add(s);
    }
    public int compareTo(Picture p) {
        // trick is that when you invert a cell, you always decrease the total possible inversions
        int thisinv = 0, pinv = 0;
        int N = this.pic.size(), M = this.pic.get(0).length();
        int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{1, 0, -1, 0};
        
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                boolean thisb = true, pb = true;
                for (int mv = 0; mv < 4; ++mv) {
                    int ni = i + dx[mv], nj = j + dy[mv];
                    thisb &= this.pic.get(i).charAt(j) != this.pic.get(ni).charAt(nj);
                    pb &= p.pic.get(i).charAt(j) != p.pic.get(ni).charAt(nj);
                }
                if (thisb) ++thisinv;
                if (pb) ++pinv;
            }
        }

        return pinv - thisinv;
    }
    public String toString() {
        String str = "";
        for (String s : this.pic) str += s+ '\n';
        return str;
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