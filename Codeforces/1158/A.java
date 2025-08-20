import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		long[] B = new long[N], G = new long[M];
		for (int i = 0; i < N; i++) B[i] = sc.nextLong();
		for (int i = 0; i < M; i++) G[i] = sc.nextLong();
		// if the biggest element in B is alr greater than the smallest in G, ur cooked
		Arrays.sort(B);
		Arrays.sort(G);
		if (B[N - 1] > G[0]) {
			System.out.println(-1);
			return;
		}

		// by default, answer should be (sum of B) * M
		long ans = 0;
		for (int i = 0; i < N; i++) ans += B[i];
		ans *= M;
		for (long x : G) {
			ans += Math.max(0, x - B[N-1]);
		}
		// edge case
		if (G[0] > B[N-1]) {
			ans -= G[0] - B[N-1];
			ans += G[0] - B[N-2];
		}
		System.out.println(ans);
	}
}