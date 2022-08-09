// Joaquin

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Joaquin {
	static Scanner sc;
	
	static char[][] square(char[][] mat, int left, int right) {
		for (int i = left; i <= right; i++) mat[i][left] = mat[i][right] = 'X';
		for (int j = left; j <= right; j++) mat[left][j] = mat[right][j] = 'X';
		return mat;
	}

	static void solve() {
		int N = sc.nextInt();
		char[][] mat = new char[N][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) mat[i][j] = ' ';
		int L = 0, R = N-1;
		while (L <= R) {
			mat = square(mat, L, R);
			L += 2;
			R -= 2;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) out.print(mat[i][j]);
			out.println();
		}
		out.println("--------------------");
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("joaquin.dat"));
		int T = sc.nextInt();
		while(T-->0) solve();
	}
} 
