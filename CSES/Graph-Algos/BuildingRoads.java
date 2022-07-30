// CSES Building Roads

import java.util.*;
import java.io.*;

public class BuildingRoads {

	static int n,m;
	static ArrayList<Integer>[] graph;
	static boolean[] vis;
	static ArrayList<Integer> comps = new ArrayList<Integer>();

	static int comp() {
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				comps.add(i);
				dfs(i);
			}
		}
		return comps.size();
	}

	static void dfs(int x) {
		if (vis[x]) return;
		vis[x] = true;
		for (int i : graph[x]) dfs(i);
	}

	public static void main(String[] args) throws IOException {
		FastIO out = new FastIO();
		n = out.nextInt(); m = out.nextInt();
		graph = new ArrayList[n+1];
		vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = out.nextInt(), b = out.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		int cnt = comp();
		// for (int i : comps) System.out.println(i);
		out.println(cnt-1);
		for (int i = 1; i < cnt; i++) {
			out.println(comps.get(i-1) + " " + comps.get(i));
		}

		out.close();
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
