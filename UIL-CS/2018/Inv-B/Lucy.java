// Lucy

import java.util.*;
import java.io.*;

public class Lucy {
	static Scanner sc;

	static void solve() {
		int n = sc.nextInt();
		sc.nextLine();
		char[][] c = new char[n][n];
		for (int i = 0; i < n; i++) c[i] = sc.nextLine().toCharArray();
		for (int i = 0; i < n; i++) {
			char cur = c[i][0];
			int tot = 0, m = c[i].length;
			for (int j = 0; j < m; j++) {
				if (c[i][j] == cur) ++tot;
				else {
					System.out.print(cur + "" + tot);
					cur = c[i][j]; tot = 1;
				}
			}
			System.out.println(cur + "" + tot);
		}
		System.out.println("=====");
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("lucy.dat"));
		int T = sc.nextInt();
		while(T-->0) solve();
	}
}