// Bryce

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Bryce {
	static Scanner sc;

	static void solve() {
		int n = sc.nextInt();
		out.print(n + ":");
		while(n >= 1000) {
			out.print('M');
			n -= 1000;
		}
		if (n >= 900) {
			out.print("CM");
			n -= 900;
		}
		if (n >= 500) {
			out.print('D');
			n -= 500;
		}
		while(n >= 100) {
			out.print('C');
			n -= 100;
		}
		if (n >= 90) {
			out.print("XC");
			n -= 90;
		}
		if (n >= 50) {
			out.print("L");
			n -= 50;
		}
		while (n >= 10) {
			out.print("X");
			n -= 10;
		}
		String[] rem = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		out.println(rem[n]);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("bryce.dat"));
		while(sc.hasNextInt()) solve();
	}
} 
