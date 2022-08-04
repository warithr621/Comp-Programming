// Bayani

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Bayani {
	static Scanner sc;

	static void solve() {
		double sum = 0;
		while(sc.hasNextDouble()) {
			double d = sc.nextDouble();
			out.printf("        $%7.2f\n", d);
			sum += d;
		}
		out.printf("Total = $%7.2f\n", sum);
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("bayani.dat"));
		solve();
	}
}