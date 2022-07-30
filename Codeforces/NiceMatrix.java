// https://codeforces.com/contest/1422/problem/B

import java.util.*;
import java.io.*;

public class NiceMatrix {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt(), m = sc.nextInt();
			int[][] mat = new int[n][m];
			for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
			long[][] yay = new long[n][m];
			long ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					long[] arr = new long[]{mat[i][j], mat[n-i-1][m-j-1], mat[n-i-1][j], mat[i][m-j-1]};
					Arrays.sort(arr);
					long avg = arr[1] + arr[2];
					avg >>= 1;
					yay[i][j] = yay[n-i-1][m-j-1] = avg;
					yay[n-i-1][j] = yay[i][m-j-1] = avg;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					ans += Math.abs(mat[i][j] - yay[i][j]);
				}
			}
			out.println(ans);
		}

		out.close();
	}
}