// Guangli

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Guangli {
	static Scanner sc;

	static void solve(int tc) {
		long A = sc.nextLong(), B = sc.nextLong();
		int ans = 0;
		while (A != B) {
			if (A > B) A >>= 1;
			else B >>= 1;
			++ans;
		}
		out.printf("Case #%d: %d\n", tc, ans);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// sc = new Scanner(System.in);
		sc = new Scanner(new File("guangli.dat"));
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) solve(i);
	}
} 
