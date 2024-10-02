
/*
Im Nayeon
Yoo Jeongyeon
Momo Jjang
Sana Jjang
Park Jihyo
Mina Jjang
Kim Dahyun
Son Chaeyoung
Chou Tzuyu
One in a million
눈부시게 사랑해
트와이스 !!
*/

import java.io.*;
import java.util.*;

public class A {
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
        int N = nexti(), K = nexti(), C = nexti();
        School[] arr = new School[N];
        for (int i = 0; i < N; i++) {
        	int T = nexti(), S = nexti();
        	arr[i] = new School(T, S, i);
        }
        ArrayList<School> ans = new ArrayList<>();
        int[] cnt = new int[N+5];
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N && ans.size() != K; i++) {
        	if (cnt[arr[i].school] != C) {
        		ans.add(arr[i]);
        		vis[i] = true;
        		cnt[arr[i].school]++;
        	}
        }
        for (int i = 0; i < N && ans.size() != K; i++) {
        	if (!vis[i]) {
        		ans.add(arr[i]);
        	}
        }
        Collections.sort(ans);
        for (School s : ans) {
        	System.out.println(s.ID);
        }
    }
}

class School implements Comparable<School> {
    int ID, school, idx;
    School(int x, int y, int z) {
        this.ID = x;
        this.school = y;
        this.idx = z;
    }
    public int compareTo(School s) {
        return idx - s.idx;
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
    int first; int second;
    Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
    public String toString() {
        return first + " " + second;
    }
    public int compareTo(Pair p) {
        return this.first == p.first ? this.second-p.second>0?1:-1 : this.first-p.first>0?1:-1;
    }
}
