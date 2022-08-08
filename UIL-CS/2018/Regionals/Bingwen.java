// Bingwen

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Bingwen {
	static Scanner sc;

	static void solve() {
    	out.printf("%.2f\n", Math.cbrt(sc.nextDouble()));
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("bingwen.dat"));
		while(sc.hasNextDouble()) solve();
	}
}