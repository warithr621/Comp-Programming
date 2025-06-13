import java.io.*;
import java.util.*;

public class D1 {
    // i have no idea what the int overflow was
    // so I just spammed long everywhere...
    static int T = 1;
    static FastIO out;
    static String next() throws IOException {return out.next();}
    static int nexti() throws IOException {return out.nextInt();}
    static long nextl() throws IOException {return out.nextLong();}
    static double nextd() throws IOException {return out.nextDouble();}
    
    public static void main(String[] args) throws IOException {
        out = new FastIO();
        T = nexti();
        while(T-->0) solve();
        out.close();
    }

    static long enc(long pos, long time, long on) {
    	// last arg is 0 if off and 1 if on
    	return (pos * K + time) * 2 + on;
    }

    static long[] states, succ;
    static int N, K;

    static boolean dfs(long node) {
    	if (node == -1) return true; // WE ESCAPED RAHH
    	if (states[(int) node] == 21) return true; // we already determined this is escape
    	if (states[(int) node] == -1) return false; // we already determined this is infinite loop
    	if (states[(int) node] == 1) return false; // i've played this game before, so i just found a cycle
    	// now mark this as done, find the next node to run dfs, and wah wah
    	states[(int) node] = -1; // mark it as in progress
    	boolean result = dfs(succ[(int) node]); // try searching to the next node
    	if (result) {
			states[(int) node] = 21; // yay we escaped
		} else {
			states[(int) node] = -1; // we found an infinite loop
		}
		return result;
    }
    
    public static void solve() throws IOException {
        // solve
        // treat the 10^100 in the problem as an infinity, no way smth is taking googol - 1 seconds
        N = nexti(); K = nexti();
        long[][] lights = new long[N][2];
        for (int i = 0; i < N; i++) lights[i][0] = nextl();
        for (int i = 0; i < N; i++) lights[i][1] = nextl();
        Arrays.sort(lights, Comparator.comparingLong((long[] a) -> a[0]).thenComparingLong(a -> a[1]));
		// for (long[] a : lights) System.out.println(Arrays.toString(a));
		long[] nextL = new long[N], nextR = new long[N];
		for (int i = 0; i < N; i++) {
			nextL[i] = i - 1 >= 0 ? i-1 : -1;
			nextR[i] = i + 1 < N ? i+1 : -1;
		}
		succ = new long[N * K * 2];
		// succ[i] is going to be the next traffic light state we hit
		for (int pos = 0; pos < N; pos++) {
			for (int time = 0; time < K; time++) {
				for (int on = 0; on < 2; on++) {
					long cur = enc(pos, time, on);
					long nextOn = on;
					if (lights[pos][1] == time) nextOn ^= 1; // if the light is red, turn around
					long nextPos = nextOn == 1 ? nextL[pos] : nextR[pos];
					if (nextPos == -1) {
						// the next position is an escape yay!
						succ[(int) cur] = -1;
					} else {
						long nextTime = time + Math.abs(lights[(int) pos][0] - lights[(int) nextPos][0]);
						succ[(int) cur] = enc(nextPos, nextTime % K, nextOn);
					}
				}
			}
		}
		// we have a bunch of states controlled by light #, time (mod K), and on/off
		states = new long[N * K * 2];
		// 0 means we haven't processed it at all yet
		// let 1 be "in progress", -1 be "infinite loop", 21 be "escape"
		// I think this essentially just becomes cycle detection??
		for (int i = 0; i < N * K * 2; i++) {
			if (states[i] == 0) dfs(i);
		}
		long Q = nextl();
		while (Q --> 0) {
			long ipos = nextl();
			if (ipos > lights[N-1][0]) {
				System.out.println("YES"); // after the last light so easy win
				continue;
			}
			// find the first position you ever hit
			long idx = Arrays.binarySearch(lights, new long[]{ipos, 0}, Comparator.comparingLong(a -> a[0]));
			if (idx < 0) idx = ~idx;
			long dist = Math.abs(lights[(int) idx][0] - ipos);
			long time = dist % K; // time is distance mod K
			System.out.println(states[(int) enc(idx, time, 0)] == 21 ? "YES" : "NO");
		}
		// System.out.println("=".repeat(20));
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
