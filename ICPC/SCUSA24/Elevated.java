import java.io.*;
import java.util.*;

public class Elevated {
	static int N, Q;
	static ArrayList<ArrayList<Integer>> adj;
	static int[] color;
	static int[] dist;
	static int[] rep;
	static int[] mx;

	public static void main(String[] args) throws Exception {
		FastIO io = new FastIO();
		N = io.nextInt();
		Q = io.nextInt();

		adj = new ArrayList<>(N + 1);
		for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

		for (int i = 0; i < N - 3; i++) {
			int u = io.nextInt();
			int v = io.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		color = new int[N + 1];
		dist = new int[N + 1];
		rep = new int[4];
		mx = new int[4];
		findComponents();

		for (int c = 1; c <= 3; c++) {
			int r = rep[c];
			int[] tmp = bfsDistances(r, c);
			int u = r;
			for (int i = 1; i <= N; i++) if (color[i] == c && tmp[i] > tmp[u]) u = i;

			int[] du = bfsDistances(u, c);
			int v = u;
			for (int i = 1; i <= N; i++) if (color[i] == c && du[i] > du[v]) v = i;
			int[] dv = bfsDistances(v, c);

			int curMax = 0;
			for (int i = 1; i <= N; i++) {
				if (color[i] == c) {
					dist[i] = Math.max(du[i], dv[i]);
					if (dist[i] > curMax) curMax = dist[i];
				}
			}
			mx[c] = curMax;
		}

		StringBuilder out = new StringBuilder();
		for (int qi = 0; qi < Q; qi++) {
			int a = io.nextInt();
			int b = io.nextInt();
			int middle = color[a] ^ color[b];
			int ans = dist[a] + 1 + mx[middle] + 1 + dist[b] + 1;
			out.append(ans).append('\n');
		}
		io.print(out.toString());
		io.close();
	}

	static void findComponents() {
		boolean[] vis = new boolean[N + 1];
		int id = 1;
		for (int i = 1; i <= N; i++) {
			if (!vis[i]) {
				Queue<Integer> q = new ArrayDeque<>();
				q.add(i);
				vis[i] = true;
				color[i] = id;
				rep[id] = i;
				while (!q.isEmpty()) {
					int node = q.poll();
					for (int neighbor : adj.get(node)) {
						if (!vis[neighbor]) {
							vis[neighbor] = true;
							color[neighbor] = id;
							q.add(neighbor);
						}
					}
				}
				id++;
			}
		}
	}

	static int[] bfsDistances(int start, int compId) {
		int[] d = new int[N + 1];
		boolean[] vis = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		vis[start] = true;
		d[start] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int neighbor : adj.get(cur)) {
				if (!vis[neighbor] && color[neighbor] == compId) {
					vis[neighbor] = true;
					d[neighbor] = d[cur] + 1;
					q.add(neighbor);
				}
			}
		}
		return d;
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