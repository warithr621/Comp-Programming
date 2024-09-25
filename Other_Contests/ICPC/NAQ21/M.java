// 2021 NAQ: Tic-Tac State

import java.util.*;

public class M {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			int N = Integer.parseInt(sc.next(), 8);
			// System.out.println(N);
			String S = Integer.toBinaryString(N);
			S = "0".repeat(19 - S.length()) + S;
			// System.out.println(S);
			boolean[] bits = new boolean[19];
			for (int i = 0; i <= 18; i++) {
				bits[i] = S.charAt(18 - i) == '1';
			}
			// System.out.println(Arrays.toString(bits));
			// check if all played
			boolean played = true;
			for (int i = 0; i <= 8; i++) played &= bits[i];
			// check if win exists
			char win = '?';
			for (int i = 9; i <= 15; i += 3) {
				if (bits[i] == bits[i+1] && bits[i] == bits[i+2] && bits[i-9] && bits[i-8] && bits[i-7]) {
					win = (bits[i] ? 'X' : 'O');
					// System.out.println("h");
				}
			}
			for (int i = 9; i <= 11; i++) {
				if (bits[i] == bits[i+3] && bits[i] == bits[i+6] && bits[i-9] && bits[i-6] && bits[i-3]) {
					win = (bits[i] ? 'X' : 'O');
					// System.out.println("v");
				}
			}
			if (bits[9] == bits[13] && bits[13] == bits[17] && bits[0] && bits[4] && bits[8]) {
				win = (bits[9] ? 'X' : 'O');
					// System.out.println("d1");
			}
			if (bits[11] == bits[13] && bits[13] == bits[15] && bits[2] && bits[4] && bits[6]) {
				win = (bits[11] ? 'X' : 'O');
					// System.out.println("d2");
			}

			if (win != '?') {
				System.out.println(win + " wins");
			} else {
				System.out.println(played ? "Cat's" : "In progress");
			}
		}
	}
}