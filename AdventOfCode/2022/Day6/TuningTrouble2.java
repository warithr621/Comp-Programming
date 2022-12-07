// AoC 2022 D6

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class TuningTrouble2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		int ans = 0;

		String s = sc.next();
		String cur = s.substring(0,14);
		int x = 14;
		while(true) {
			HashSet<Character> st = new HashSet<>();
			for (int i = 0; i < 14; i++) st.add(cur.charAt(i));
			if (st.size() == 14) {
				out.println(x);
				break;
			}

			cur = cur.substring(1) + s.charAt(x++);
		}
	}
}