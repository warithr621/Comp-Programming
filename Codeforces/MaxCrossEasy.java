// https://codeforces.com/contest/1676/problem/H1

import java.util.*;
import java.io.*;

public class MaxCrossEasy {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					ans += a[i] >= a[j] ? 1 : 0;
				}
			}
			out.println(ans);
		}

		out.close();
	}
}