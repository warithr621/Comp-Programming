// 2019 Open Silver P3

import java.util.*;
import java.io.*;

public class FencePlan {

	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st = new StringTokenizer("");
	static int N,M;
	static int coords[][];
	static boolean vis[];
	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> comp;

	static void components(int x) {
		if (vis[x]) return;
		vis[x] = true;
		comp.add(x);
		for (int point : adj[x]) components(point);
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("fenceplan.in"));
		out = new PrintWriter("fenceplan.out");

		N = ni(); M = ni();
		coords = new int[N][2];
		for (int i = 0; i < N; i++) {
			coords[i][0] = ni();
			coords[i][1] = ni();
		}

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int x = ni()-1;
			int y = ni()-1;
			adj[x].add(y);   adj[y].add(x);
		}

		int ans = Integer.MAX_VALUE;
		comp = new ArrayList<>();
		vis = new boolean[N];

		for (int i = 0; i < N; i++) {
			comp.clear();
			components(i);
			if (comp.size() == 0) continue;

			int min_x = Integer.MAX_VALUE, max_x = -1;
			int min_y = Integer.MAX_VALUE, max_y = -1;
			for (int pt : comp) {
				min_x = Math.min(min_x, coords[pt][0]);
				max_x = Math.max(max_x, coords[pt][0]);

				min_y = Math.min(min_y, coords[pt][1]);
				max_y = Math.max(max_y, coords[pt][1]);
			}

			int perimeter = 2 * (max_x - min_x + max_y - min_y);
			ans = Math.min(perimeter, ans);
		}

		out.println(ans);

		br.close(); out.close();
	}

	static int ni() throws IOException {
		while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}