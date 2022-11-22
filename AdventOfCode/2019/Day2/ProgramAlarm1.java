// AoC 2019 D2

import java.util.*;
import java.io.*;

public class ProgramAlarm1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		String[] s = sc.next().split(",");
		//1202 ERROR
		s[1] = "12"; s[2] = "2";

		for (int i = 0; i < s.length; i += 4) {
			int x = Integer.parseInt(s[i]);
			if (x == 99) break;

			int pa = Integer.parseInt(s[i+1]), pb = Integer.parseInt(s[i+2]);
			int pos = Integer.parseInt(s[i+3]);

			int a = Integer.parseInt(s[pa]), b = Integer.parseInt(s[pb]);
			s[pos] = Integer.toString(x == 1 ? a+b : a*b);

			// System.out.println(Arrays.toString(s));
		}

		System.out.println(s[0]);
	}
}