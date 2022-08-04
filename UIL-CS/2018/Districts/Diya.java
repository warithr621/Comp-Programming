// Diya

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Diya {
	static Scanner sc;

	static void solve() {
		int N = sc.nextInt();

		int[][] a = new int[N][N];
		int cur = 1, i = 0, j = 0, move = N-1;
		for (j = 0; j < N-1; j++) a[i][j] = cur++;
		i = 0; j = N-1;

		int[] dx = new int[]{1, 0, -1, 0};
		int[] dy = new int[]{0, -1, 0, 1};
		int sw = 0;

		while(move > 0) {
			int oi = i, oj = j;
			i += dx[sw] * move; j += dy[sw] * move;
			while(oi != i || oj != j) {
				a[oi][oj] = cur++;
				if (dx[sw] != 0) oi += dx[sw];
				else oj += dy[sw];
			}
			sw = (++sw)%4;

			oi = i; oj = j;
			i += dx[sw] * move; j += dy[sw] * move;
			while(oi != i || oj != j) {
				a[oi][oj] = cur++;
				if (dx[sw] != 0) oi += dx[sw];
				else oj += dy[sw];
			}
			sw = (++sw)%4;
			--move;
		}

		a[N/2][(N-1)/2] = N*N; //whoops edge case :clown:

		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) out.print(a[i][j] + " ");
			out.println();
		}
		out.println("=====");
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("diya.dat"));

		while(sc.hasNextInt()) solve();
	}
}