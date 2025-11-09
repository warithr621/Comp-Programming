import java.util.*;
import java.io.*;

public class D {

	static Scanner sc;
	static int N, P[], C[];
	static boolean vis[];

	static void solve() {
		read();
		int ans = N+1;
		for (int i = 1; i <= N; i++) {
			if (vis[i]) continue;
			// make the cycle starting at i
			List<Integer> cycle = new ArrayList<>();
			int cur = i;
			while (!vis[cur]) {
				vis[cur] = true;
				cycle.add(C[cur]);
				cur = P[cur];
			}
			// System.out.println(cycle);
			int sz = cycle.size();
			// process all factors of this
			for (int k = 1; k * k <= sz; k++) {
				if (sz % k != 0) continue;
				// try step size of k
				for (int step : new int[]{k, sz / k}) {
					// System.out.println("Step size: " + step);
					for (int start = 0; start < step; start++) {
						boolean ok = true;
						for (int pos = start + step; pos < sz; pos += step) {
							// System.out.println("Comparing " + start + " and " + pos);
							if (!cycle.get(start).equals(cycle.get(pos))) {
								ok = false;
								break;
							}
						}
						if (ok) {
							// System.out.println("k = " + step + " works!");
							ans = Math.min(ans, step);
							break;
						}
						// System.out.println("--");
					}
					// System.out.println("----");
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) solve();
	}

	static void read() {
		N = sc.nextInt();
		P = new int[N+1];
		C = new int[N+1];
		for (int i = 1; i <= N; i++) P[i] = sc.nextInt();
		for (int i = 1; i <= N; i++) C[i] = sc.nextInt();
		vis = new boolean[N+1];
	}
}