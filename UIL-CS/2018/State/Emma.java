import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Emma {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("emma.dat"));
		int T = 1;
		// T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			char[][] mat = new char[3*n][3*n];
			int len = 3*n;
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					mat[i][j] = '*';
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = n; j < 2*n; j++) {
					mat[i][j] = ' ';
				}
			}
			for (int i = len-1; i >= 2*n; i--) {
				for (int j = n; j < 2*n; j++) {
					mat[i][j] = ' ';
				}
			}

			for (int j = 0; j < n; j++) {
				for (int i = n; i < 2*n; i++) {
					mat[i][j] = ' ';
				}
			}
			for (int j = len-1; j >= 2*n; j--) {
				for (int i = n; i < 2*n; i++) {
					mat[i][j] = ' ';
				}
			}

			for (int i = n; i < 3 * n / 2; i++) {
				for (int j = i+1; j < 3 * n - i - 1; j++) {
					mat[i][j] = ' ';
				}
			}
			for (int j = n; j < 3 * n / 2; j++) {
				for (int i = j+1; i < 3 * n - j - 1; i++) {
					mat[i][j] = ' ';
				}
			}

			mat = rot(mat);
			mat = rot(mat);

			for (int i = n; i < 3 * n / 2; i++) {
				for (int j = i+1; j < 3 * n - i - 1; j++) {
					mat[i][j] = ' ';
				}
			}
			for (int j = n; j < 3 * n / 2; j++) {
				for (int i = j+1; i < 3 * n - j - 1; i++) {
					mat[i][j] = ' ';
				}
			}

			for (char[] c : mat) out.println(c);
			out.println("==========");
		}
	}

	static char[][] rot(char[][] mat) {
		int n = mat[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				char temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			int L = 0, R = n-1;
			while(L < R) {
				char temp = mat[i][L];
				mat[i][L] = mat[i][R];
				mat[i][R] = temp;
				++L; --R;
			}
		}
		return mat;
	}
}