// https://codeforces.com/contest/1843/problem/D

import java.io.*;
import java.util.*;
 
public class Main {
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
	
	static int N;
	static ArrayList<Integer>[] graph;
	static long[] ops;
	
	static long dfs(int cur, int prev) {
	   // out.printf("Testing node %d with prev %d\n", cur, prev);
	    if (graph[cur].size() == 1 && cur != 1) {
	        ops[cur] = 1L;
	        return 1L;
	    }
	    int sum = 0;
	    for (int x : graph[cur]) {
	       // out.printf("Cur = %d, adj = %d\n", cur, x);
	        if (x != prev) sum += dfs(x, cur); // don't backtrack
	    }
	    ops[cur] = sum;
	    return sum; // hopefully this works :clown:
	}
	
	public static void solve() throws IOException {
	    //solve
	    N = nexti();
	    graph = new ArrayList[N+1];
	    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<Integer>();
	    for (int i = 0; i < N-1; i++) {
	        int U = nexti(), V = nexti();
	        graph[U].add(V);
	        graph[V].add(U);
	       // out.println(U + " " + V);
	    }
	    
	    // now just DFS on the number of options?
	    ops = new long[N+1];
	    dfs(1, 0);
	   // System.out.println(Arrays.toString(ops));
	    
	    int Q = nexti();
	    while(Q --> 0) {
	        int x = nexti(), y = nexti();
	        out.println(ops[x] * ops[y]);
	    }
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