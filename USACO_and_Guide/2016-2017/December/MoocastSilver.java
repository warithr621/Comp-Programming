// 2016 Dec Silver P3

import java.util.*;
import java.io.*;

public class MoocastSilver {
	static BufferedReader br;
	static PrintWriter out;
	static int N;
	static int coords[][];
	static int range[];
	static boolean vis[][];

	static void dfs(int x, int row) {
		if (vis[row][x]) return;
		vis[row][x] = true;

		for (int i = 0; i < N; i++) {
			if (i == x) continue;

			int x_dist = Math.abs(coords[i][0] - coords[x][0]);
			int y_dist = Math.abs(coords[i][1] - coords[x][1]);
			if (1L * x_dist * x_dist + 1L * y_dist * y_dist <= 1L * range[x] * range[x]) {
				dfs(i, row);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("moocast.in"));
		out = new PrintWriter("moocast.out");
		// br = new BufferedReader(new InputStreamReader(System.in));
		// out = new PrintWriter(System.out);

		N = Integer.parseInt(br.readLine());
		coords = new int[N][N];
		range = new int[N];
		vis = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coords[i][0] = Integer.parseInt(st.nextToken());
			coords[i][1] = Integer.parseInt(st.nextToken());
			range[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) dfs(i, i);

		int cnt = 0;
		for (boolean[] b : vis) {
			int cur = 0;
			for (int i = 0; i < N; i++) if (b[i]) ++cur;
			cnt = Math.max(cnt, cur);
			// out.println(Arrays.toString(b));
		}
		out.println(cnt);

		br.close(); out.close();
	}
}
