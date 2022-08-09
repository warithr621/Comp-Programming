// Goro

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Goro {
	static Scanner sc;

	static void solve() {
		int N = sc.nextInt();
		double cur = 0;
		for (int i = 0; i < N; i++) {
			double den = 1.0 * (2 * i + 1) * Math.pow(3, i);
			if (i % 2 == 0) cur += 1 / den;
			else cur -= 1/den;
		    
			out.printf("%.5f\n", Math.sqrt(12) * cur);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("goro.dat"));
		solve();
	}
} 
