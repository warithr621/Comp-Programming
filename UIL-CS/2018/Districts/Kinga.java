// Kinga

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Kinga {
	static Scanner sc;

	static void solve() {
		int N = sc.nextInt();
		int mx = (1 << N), sp = 0;
		if (mx < 10) {out.print("  "); sp = 2;}
		else if (mx < 100) {out.print("   "); sp = 3;}
		else {out.print("    "); sp = 4;}
		for (char c = 'A'; c < 'A' + N; c++) out.print((c == 'A' ? "" : "|") + c);
		out.println();
		for (int i = 1; i <= mx; i++) {
			out.print(i);
			for (int tmp = 0; tmp < sp - Integer.toString(i).length(); ++tmp) out.print(' '); // spacing moment

			String bin = Integer.toString(i-1, 2);
			while(bin.length() != N) bin = "0" + bin;
			for (int j = 0; j < N; j++) out.print((j == 0 ? "" : "|") + bin.charAt(j));
			out.println();
		}
		out.println("=====");
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("kinga.dat"));
		while(sc.hasNextInt()) solve();
	}
}