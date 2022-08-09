// Luis

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Luis {
	static Scanner sc;

	static void solve() {
		TreeMap<String, Double> tm = new TreeMap<>();
		int[][] cl = new int[10][2];
		String[] subj = new String[]{"Algebra", "Calculus", "Computer Science",
			"Economics", "English", "Geometry", "Government", "Spanish",
			"U.S. History", "World History"};
		while(sc.hasNextLine()) {
			String[] s = sc.nextLine().split(",");
			String name = String.format("%s %s", s[1], s[0]);
			int tot = 0, score = 0;
			for (int i = 0; i < 10; i++) {
				if (s[i+2].equals("NA")) continue;
				cl[i][0] += Integer.parseInt(s[i+2]);
				score += Integer.parseInt(s[i+2]);
				++tot; ++cl[i][1];
			}
			tm.put(name, score / 1.0 / tot);
		}
		for (String s : tm.keySet()) {
			String[] tmp = s.split(" ");
			out.printf("%s %s %.3f\n", tmp[1], tmp[0], tm.get(s));
		}
		for (int i = 0; i < 20; i++) out.print('*'); out.println();
		for (int i = 0; i < 10; i++) out.printf("%s %.3f\n", subj[i],cl[i][0] / 1.0 / cl[i][1]);

	}

	public static void main(String[] args) throws FileNotFoundException {
		// sc = new Scanner(System.in);
		sc = new Scanner(new File("luis.dat"));
		solve();
	}
} 
