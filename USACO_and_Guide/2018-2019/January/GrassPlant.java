// 2019 Jan Silver P1

import java.util.*;
import java.io.*;

public class GrassPlant {
	static Scanner sc;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new File("planting.in"));
		out = new PrintWriter("planting.out");
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = 0;
		for (int i = 0; i < n-1; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			--x; --y;
			++a[x]; ++a[y];
		}
		int ans = 0;
		for (int i : a) ans = Math.max(i, ans);
		out.println(++ans);
		out.close();
	}
}