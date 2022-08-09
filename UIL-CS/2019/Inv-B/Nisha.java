// Nisha

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Nisha {
	static Scanner sc;

	static void solve(int tc) {
		long k = sc.nextLong();
		out.printf("Case #%d: %d\n", tc, 1L + (1L << k) / 2 * k);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("nisha.dat"));
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) solve(i);
	}
} 
