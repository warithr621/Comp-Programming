// Brenda

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Brenda {
	static Scanner sc;

	static void solve() {
		int[] a = new int[4];
		for (int i = 0; i < 4; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		for (int x : a) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) out.print("X");
				out.println();
			}
			out.println("--------------------");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// sc = new Scanner(System.in);
		sc = new Scanner(new File("brenda.dat"));
		solve();
	}
} 
