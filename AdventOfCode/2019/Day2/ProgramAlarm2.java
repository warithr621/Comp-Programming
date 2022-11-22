// AoC 2019 D2

import java.util.*;
import java.io.*;

public class ProgramAlarm2 {

	public static boolean test(String[] inp, int n, int v) {
		String[] s = Arrays.copyOf(inp, inp.length);
		s[1] = Integer.toString(n); s[2] = Integer.toString(v);
		// Java being weird so I had to make a new array for some reason??
		// I think I just messed something up conceptually but idk

		for (int i = 0; i < s.length; i += 4) {
			// System.out.println("exec" + i);
			int x = Integer.parseInt(s[i]);
			if (x == 99) break;

			try {
				int pa = Integer.parseInt(s[i+1]), pb = Integer.parseInt(s[i+2]);
				int pos = Integer.parseInt(s[i+3]);

				int a = Integer.parseInt(s[pa]), b = Integer.parseInt(s[pb]);
				s[pos] = Integer.toString(x == 1 ? a+b : a*b);
			} catch (Exception e) {break;}

			// System.out.println(Arrays.toString(s));
		}

		return s[0].equals("19690720");
	}


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		String[] inp = sc.next().split(",");
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (test(inp,i,j)) System.out.println(100*i+j);
			}
		}
	}
}