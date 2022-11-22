// https://codeforces.com/contest/1020/problem/B

import java.util.*;

public class Badge {

	static int N;
	static int[] graph;
	static int[][] holes;

	static int dfs(int start, int cur) {
		holes[start][cur]++;
		if (holes[start][cur] == 2) return cur;
		else return dfs(start, graph[cur]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		graph = new int[N];
		holes = new int[N][N];

		for (int i = 0; i < N; i++) graph[i] = sc.nextInt() - 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) holes[i][j] = 0;
			System.out.print(dfs(i, i) + 1 + " ");
		}
	}
}
