// Abhi

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Abhi {
	static Scanner sc;

	static boolean prime(int x) {
		if (x <= 3) return true;
		for (int i = 2; i * i <= x; i++) if (x % i == 0) return false;
		return true;
	}
	static void solve() {
		int p = 2;
		int cnt = 0;
		while(cnt < 200) {
			if (prime(p)) {
				++cnt;
				out.print((char) ((p + 25) % 26 + 'A'));
				if (cnt % 20 == 0) out.println();
			}
			++p;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
// 		sc = new Scanner(new File("abhi.dat"));
		solve();
	}
} 