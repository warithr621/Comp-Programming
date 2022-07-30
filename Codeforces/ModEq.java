// https://codeforces.com/contest/1269/problem/B

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class ModEq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[] a = new int[n], b = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		for (int i = 0; i < n; i++) b[i] = sc.nextInt();
		Arrays.sort(b);
		HashSet<Integer> pos = new HashSet<>();
		for (int i : a) pos.add((b[0] - i + m) % m);
		for (int ans : pos) {
			int[] maybe = new int[n];
			for (int i = 0; i < n; i++) maybe[i] = (a[i] + ans) % m;
			Arrays.sort(maybe);
			boolean works = true;
			for (int i = 0; i < n; i++) {
				if (maybe[i] != b[i]) works = false;
			}
			if (works) {
				out.println(ans);
				return;
			}
		}
	}
}