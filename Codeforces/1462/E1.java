import java.util.*;

public class E1 {

	public static long C(long n, long r) {
		// only 2 or 3 anyways
		if (r == 2) return (n * (n-1)) >> 1;
		else return n * (n-1) * (n-2) / 6;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			int N = sc.nextInt();
			int[] A = new int[N];
			boolean[] cont = new boolean[N+1];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				cont[A[i]] = true;
			}
			Map<Integer, Long> f = new HashMap<>(); // frequency map
			for (int x : A) {
				f.put(x, f.getOrDefault(x, 0L) + 1L);
			}
			// System.out.println(f.keySet());
			// lowkey just do a bunch of cases
			// "x x x", "x x x+1", "x x+1 x+1" "x x x+2", "x x+1 x+2", "x x+2 x+2"
			long ans = 0;
			for (int x : f.keySet()) {
				long a = f.get(x);
				long b = (x+1 <= N && cont[x+1] ? f.get(x+1) : -1);
				long c = (x+2 <= N && cont[x+2] ? f.get(x+2) : -1);
				if (a >= 3) ans += C(a, 3);
				if (a >= 2 && b >= 1) ans += C(a, 2) * b;
				if (a >= 1 && b >= 2) ans += a * C(b, 2);
				if (a >= 2 && c >= 1) ans += C(a, 2) * c;
				if (a >= 1 && b >= 1 && c >= 1) ans += a * b * c;
				if (a >= 1 && c >=2 ) ans += a * C(c, 2);
			}
			System.out.println(ans);
		}
	}
}