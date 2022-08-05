// Barb

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Barb {
	static Scanner sc;

	static void solve() {
		int N = sc.nextInt();
		out.println("A   A*A   3*A   A/2");
		for (int i = 1; i <= N; i++) out.printf("%d     %d     %d     %d\n", i, i*i, 3*i, i/2);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("barb.dat"));
		solve();
	}
} 