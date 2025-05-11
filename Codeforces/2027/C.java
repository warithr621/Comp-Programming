import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());

		while (T --> 0) {
			int N = Integer.parseInt(br.readLine());
			long[] A = new long[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				A[i] = Long.parseLong(st.nextToken());
			}

			Map<Long, ArrayList<Long>> adj = new HashMap<>(2 * N);
			for (int i = 2; i <= N; i++) {
				long u = A[i] + i - 1;
				long v = u + i - 1;
				adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
			}
			
			long ans = N;
			Queue<Long> q = new ArrayDeque<>();
			Set<Long> vis = new HashSet<>(2 * N);
			q.add((long) N);
			vis.add((long) N);
			while (!q.isEmpty()) {
				long cur = q.poll();
				ans = Math.max(ans, cur);
				List<Long> neighbors = adj.get(cur);
				if (neighbors == null) continue;
				for (long dest : neighbors) {
					if (vis.add(dest)) q.add(dest);
				}
			}
			out.println(ans);
		}

		br.close(); out.close();
	}
}