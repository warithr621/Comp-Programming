import java.util.*;

public class E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		sc.nextLine();
		char[][] grid = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			grid[i] = s.toCharArray();
		}
		List<int[]> start = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ('A' <= grid[i][j] && grid[i][j] <= 'W') {
					start.add(new int[] { i, j });
				}
			}
		}
		boolean[][] vis = new boolean[N][M];
		int used = 0;
		for (int[] s : start) {
			int x = s[0], y = s[1];
			if (vis[x][y]) continue;
			// System.out.println("Using " + ((char) ('A' + i)));
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { x, y });
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			int dots = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int cx = cur[0], cy = cur[1];
				if (vis[cx][cy]) continue;
				vis[cx][cy] = true;
				if (grid[cx][cy] == '.') ++dots;
				for (int d = 0; d < 4; d++) {
					int nx = cx + dx[d], ny = cy + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if (vis[nx][ny] || grid[nx][ny] == 'X') continue;
					if (('A' <= grid[cx][cy] && grid[cx][cy] <= 'W') && ('A' <= grid[nx][ny] && grid[nx][ny] <= 'W')) {
						continue;
					}
					q.offer(new int[] { nx, ny });
				}
			}
			if (dots != 0) ++used;
		}
		int left = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!vis[i][j] && grid[i][j] == '.') ++left;
			}
		}
		System.out.println(used + " " + left);
	}
}