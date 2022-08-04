// Jeremy

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Jeremy {
	static Scanner sc;

	static ArrayList<Integer[]> pts;
	static boolean[][] vis;
	static int R, C;
	static int[][] a;

	static void flood(int x, int y, int color) {
		if (x < 0 || x >= R) return;
		if (y < 0 || y >= C) return;
		if (a[x][y] != color) return;
		if (vis[x][y]) return;

		vis[x][y] = true;
		pts.add(new Integer[]{x, y});
		flood(x-1, y, color);
		flood(x+1, y, color);
		flood(x, y-1, color);
		flood(x, y+1, color);
	}

	static void solve() {
		R = sc.nextInt(); C = sc.nextInt();
		a = new int[R][C];
		for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) a[i][j] = sc.nextInt();

		pts = new ArrayList<Integer[]>();
		vis = new boolean[R][C];
		int x = sc.nextInt(), y = sc.nextInt();
		int orig = a[x][y], fin = sc.nextInt();
		flood(x, y, orig);

		for (Integer[] arr : pts) a[arr[0]][arr[1]] = fin;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) out.print(a[i][j] + " ");
			out.println();
		}
		out.println("=====");
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("jeremy.dat"));
		int T = sc.nextInt();
		while(T-->0) solve();
	}
}