//https://codeforces.com/contest/1569/problem/B

import java.util.*;

public class Chess {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			String s = sc.next();
			solve(n, s);
		}
	}

	static void solve(int n, String s) {
		char[][] mat = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = i == j ? 'X' : '=';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (s.charAt(i) == '1' && s.charAt(j) == '1') {
					mat[i][j] = mat[j][i] = '=';
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (s.charAt(i) == '1' && s.charAt(j) == '2') {
					mat[i][j] = mat[j][i] = '=';
				}
			}
		}
		ArrayList<Integer> twos = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '2') twos.add(i);
		}
		if (twos.size() == 1 || twos.size() == 2) {
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		for (int i = 0; i < twos.size(); i++) {
			int first = twos.get(i);
			int second = twos.get(i == twos.size()-1 ? 0 : i+1);
			mat[first][second] = '+';
			mat[second][first] = '-';
		}
		for (char[] c : mat) System.out.println(c);
	}
}