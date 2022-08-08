// Klara

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Klara {
	static Scanner sc;

	static ArrayList<Integer[]> pts;
	static boolean[][] vis;
	static int n;
	static char[][] a;

	static void flood(int x, int y, char color) {
		if (x < 0 || x >= n) return;
		if (y < 0 || y >= n) return;
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
	    n = sc.nextInt();
	    a = new char[n][n];
	    for (int i = 0; i < n; i++) a[i] = sc.next().toCharArray();

		pts = new ArrayList<Integer[]>();
		vis = new boolean[n][n];
		char orig = a[n/2][n/2];
		flood(n/2, n/2, orig);

		for (Integer[] arr : pts) a[arr[0]][arr[1]] = '-';

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) out.print(a[i][j]);
			out.println();
		}
		out.println("=====");
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("klara.dat"));
		while(sc.hasNext()) solve();
	}
} 