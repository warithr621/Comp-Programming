import java.util.*;

public class C {

	static Scanner sc = new Scanner(System.in);

	static int query(int r, int c) {
		System.out.println("? " + r + " " + c);
		System.out.flush();
		return sc.nextInt();
	}

	static void answer(int r, int c) {
		System.out.println("! " + r + " " + c);
		System.out.flush();
	}

	public static void main(String[] args) {
		int T = sc.nextInt();
		while (T --> 0) {
			int N = sc.nextInt(), M = sc.nextInt();

			int x = 1, y = 1;
			int d1 = query(x, y);
			if (d1 == 0) {
				answer(x, y);
				continue;
			}

			x = Math.min(1 + d1, N);
			y = Math.min(1 + d1, M);
			int d2 = query(x, y);
			if (d2 == 0) {
				answer(x, y);
				continue;
			}

			if (x - d2 <= 0) {
				answer(x, y - d2);
				continue;
			}
			int d3 = query(x - d2, y);
			if (d3 == 0) {
				answer(x - d2, y);
			} else {
				answer(x, y - d2);
			}
		}
		sc.close();
	}

}