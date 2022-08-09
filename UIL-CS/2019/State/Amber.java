// Amber

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Amber {
	static Scanner sc;

	static void solve(int tc) {
		int L = sc.nextInt();
		double ans = 0;
		while(L-->0) {
			double D = sc.nextDouble(), A = sc.nextDouble();
			ans += D * Math.sin(A * Math.PI / 180);
		}
		out.printf("Run #%d %d meters.\n", tc, Math.round(ans));
	}

	public static void main(String[] args) throws FileNotFoundException {
		// sc = new Scanner(System.in);
		sc = new Scanner(new File("amber.dat"));
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) solve(i);
	}
}
