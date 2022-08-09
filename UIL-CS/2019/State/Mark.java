// Mark

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Mark {
	static Scanner sc;

	static void solve() {
		int pos = 0, cur = 0;
		boolean parity = false;
    	while(sc.hasNextDouble()) {
			parity = !parity;
			double d = sc.nextDouble() / 22.5;
			pos = (pos + (int) d + 80) % 16;
			if (parity) cur += pos * 16;
			else {
				cur += pos;
				out.print((char) cur);
				if (cur == '!' || cur == '.' || cur == '?') out.println();
				cur = 0;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
	    // sc = new Scanner(System.in);
		sc = new Scanner(new File("mark.dat"));
		solve();
	}
} 