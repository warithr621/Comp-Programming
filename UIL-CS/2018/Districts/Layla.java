// Layla

import java.util.*;
import java.io.*;

public class Layla {
	static Scanner sc;

	static void pront(double a, double b, double c) {
		System.out.printf("A = %.3f\nB = %.3f\nC = %.3f\n=====\n", a,b,c);
	}

	static void solve() {
		double x = sc.nextDouble(), y = sc.nextDouble(), d = sc.nextDouble();
		char c = sc.next().charAt(0);
		if (c == 'A') pront(d, d/x, d/x/y);
		else if (c == 'B') pront(d*x, d, d/y);
		else pront(d*x*y, d*y, d);
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("layla.dat"));
		while(sc.hasNext()) solve();
	}
}