import java.util.*;

public class G {
	static int N, M;
	static char[][] grid;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int sx = -1, sy = -1, ex = -1, ey = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		grid = new char[N][M]; // why did I even make these static
		for (int i = 0; i < N; i++) {
			grid[i] = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 'S') {
					sx = i; sy = j;
				}
				if (grid[i][j] == 'E') {
					ex = i; ey = j;
				}
			}
		}
		Map<Integer, Integer> pairs = new HashMap<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 'C') {
					pairs.put(i * M + j, ++cnt);
				}
			}
		}
		boolean[][][] vis = new boolean[9][N][M]; // wtaf
		Queue<State> q = new LinkedList<>();
		int ans = Integer.MAX_VALUE;
		q.add(new State(sx, sy, 0, 0, 0));
		while (!q.isEmpty()) {
			State st = q.poll();
			int x = st.x, y = st.y, c = st.corn, m = st.move, b = st.bitset;
			// System.out.println(x + " " + y + " " + c + " " + m);
			if (x == ex && y == ey) {
				// update answer
				ans = Math.min(ans, st.move);
				continue;
			}
			++m;
			if (vis[c][x][y] || grid[x][y] == 'P') continue;
			vis[c][x][y] = true;
			if (grid[x][y] == 'C') {
				// wait, have I visited this before?
				int pos = pairs.get(x * M + y);
				if (st.visited(pos)) continue;
				++c;
				b |= (1 << pos);
			}
			if (c > 8) continue;
			if (grid[x][y] == 'J') {
				// spend or like die
				if (c != 0) --c;
				else continue;
			}
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k], ny = y + dy[k];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (vis[c][nx][ny]) continue;
				q.add(new State(nx, ny, c, m, b));
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? "SPOOKED!" : Integer.toString(ans));
	}
}

class State {
	int x, y, corn, move, bitset = 0;
	State(int i, int j, int c, int m, int b) {
		this.x = i;
		this.y = j;
		this.corn = c;
		this.move = m;
		this.bitset = b;
	}
	public boolean visited(int pos) {
		return !((bitset & (1 << pos)) == 0);
	}
}