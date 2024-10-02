// 2021 NAQ: Stamp Combinations

import java.util.*;

public class K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt();
		int[] S = new int[M];
		for (int i = 0; i < M; i++) {
			S[i] = sc.nextInt();
		}
		// is this just prefix and suffix sums???
		int[] pfx = new int[M+1], sfx = new int[M+1];
		for (int i = 1; i <= M; i++) {
			pfx[i] = pfx[i-1] + S[i-1];
		}
		for (int i = M-1; i >= 0; i--) {
			sfx[i] = sfx[i+1] + S[i];
		}

		// System.out.println(Arrays.toString(pfx));
		// System.out.println(Arrays.toString(sfx));
		while (N --> 0) {
			int Q = sc.nextInt();
			boolean found = false;
			int j = 0;
			if (Q > sfx[0]) {
				System.out.println("No");
				continue;
			}
			for (int i = 0; i <= M; i++) {
				while (j <= M && pfx[i] + sfx[j] > Q) ++j;
				if (j == M+1) break;
				if (pfx[i] + sfx[j] == Q) {
					found = true;
					break;
				}
			}
			System.out.println(found ? "Yes" : "No");
			// System.out.println('\n');
		}
	}
}