import java.util.*;
import java.io.*;

public class F {
	public static void main(String[] args) throws IOException {
		FastIO out = new FastIO();
		int T = out.nextInt();
		while (T --> 0) {
			int N = out.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = out.nextInt();
			}
			List<ArrayList<Integer>> adj = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				adj.add(new ArrayList<>());
			}
			for (int i = 0; i < N-1; i++) {
				int u = out.nextInt() - 1;
				int v = out.nextInt() - 1;
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			boolean[] ans = new boolean[N];
			// basically need to check if either
				// an edge connects two numbers of same value
				// a number has two equal neighbors
			for (int i = 0; i < N; i++) {
				Map<Integer, Integer> countMap = new HashMap<>();
				for (int neighbor : adj.get(i)) {
					// System.out.println(i + "->" + neighbor);
					if (A[neighbor] == A[i]) {
						ans[A[neighbor] - 1] = true;
					}
					countMap.put(A[neighbor], countMap.getOrDefault(A[neighbor], 0) + 1);
					if (countMap.get(A[neighbor]) >= 2) {
						ans[A[neighbor] - 1] = true;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(ans[i] ? "1" : "0");
			}
			out.println(sb.toString());
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