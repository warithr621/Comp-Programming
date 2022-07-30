// 2018 Dec Silver P3

import java.util.*;
import java.io.*;

public class Mooyo {
	static Scanner sc;
	static PrintWriter out;
	static int n,k;
	static char[][] mat;
	static boolean[][] vis;
	static char color;
	static ArrayList<Integer[]> al;

	static void flood(int i, int j, char color) {
		if (i < 0 || i >= n) return;
		if (j < 0 || j >= 10) return;
		if (vis[i][j]) return;
		if (mat[i][j] != color) return;

		vis[i][j] = true;
		al.add(new Integer[]{i, j});
		flood(i-1, j, color);
		flood(i+1, j, color);
		flood(i, j-1, color);
		flood(i, j+1, color);
	}	

	static void gravity() {
		for (int j = 0; j < 10; j++) {
			for (int i = n-1; i >= 0; i--) {
				//fixing mat[i][j]
				if (mat[i][j] != '0') {
					//shift it down as much as possible
					int k = i+1;
					while(k < n && mat[k][j] == '0') {
						char temp = mat[k-1][j];
						mat[k-1][j] = mat[k][j];
						mat[k][j] = temp;
						++k;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new File("mooyomooyo.in"));
		out = new PrintWriter("mooyomooyo.out");
		n = sc.nextInt(); k = sc.nextInt();
		al = new ArrayList<>();
		mat = new char[n][10];
		for (int i = 0; i < n; i++) mat[i] = sc.next().toCharArray();
		vis = new boolean[n][10];
		int cnt = 1;
		while (cnt != 0) {
			cnt = 0;
			al.clear();
			vis = new boolean[n][10];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 10; j++) {
					al.clear();
					color = mat[i][j];
					if (color == '0') continue;
					// out.println(i + " " + j);
					flood(i, j, color);
					// for (Integer[] arr : al) out.println(Arrays.toString(arr));
					if (al.size() >= k) {
						++cnt;
						for (Integer[] arr : al) {
							int x = arr[0];
							int y = arr[1];
							mat[x][y] = '0';
						}
					}
				}
			}
			gravity();
			// out.println("ITERATION COMPLETE");
			// for (int i = 0; i < n; i++) {
			// 	for (int j = 0; j < 10; j++) out.print(mat[i][j]);
			// 	out.println();
			// }
			// out.println("==========");
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) out.print(mat[i][j]);
			out.println();
		}
		out.close();
	}
}