// Sean

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Sean {
	static Scanner sc;

	static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

	static void solve() {
		int n = sc.nextInt();
		char[][] mat = new char[n][n];
		boolean[][] vis;
		int[][] dist = new int[n][1000];
		for (int i = 0; i < n; i++) for (int j = 0; j < 1000; j++) dist[i][j] = 123456;
		for (int i = 0; i < n; i++) {
			mat[i] = sc.next().toCharArray();
		}
		Queue<Integer[]> q;
		while(sc.hasNextInt()) {
			int x = sc.nextInt(), y = sc.nextInt();
			vis = new boolean[n][1000];
			q = new LinkedList<>();
			q.add(new Integer[]{x, y, 0});
			while(!q.isEmpty()) {
				Integer[] arr = q.remove();
				int u = arr[0], v = arr[1], d = arr[2];
				// out.printf("(%d, %d) dist = %d\n", u, v, d);
				if (vis[u][v]) continue;
				if (mat[u][v] == 'X') continue;
				vis[u][v] = true;
				dist[u][v] = Math.min(dist[u][v], d);
				for (int i = 0; i < 8; i++) {
					q.add(new Integer[]{u+dx[i], v+dy[i], d+1});
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 'X') out.print('X');
				else if (dist[i][j] == 123456) out.print('.');
				else out.print(dist[i][j] % 10);
			}
			out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
	    // sc = new Scanner(System.in);
		sc = new Scanner(new File("sean.dat"));
		solve();
	}
} 