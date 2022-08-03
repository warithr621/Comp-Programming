import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Dennis {
	static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("dennis.dat"));
		int T = 1;
		T = sc.nextInt();
		while(T-->0) solve();
	}

	static void solve() {
		int n = sc.nextInt();
		String[] a = new String[n];
		int mx = -1;
		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
			mx = Math.max(mx, a[i].length());
		}
		for (int i = 0; i < mx; i++) {
			for (String str : a) {
				if (i < str.length()) out.print(str.charAt(i));
				else out.print(" ");
			}
			out.println();
		}
		for (String str : a) out.print("*");
		out.println();
	}
}