// Gleb

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Gleb {
	static Scanner sc;

	static ArrayList<String> key = new ArrayList<String>();

	static void solve() {
		String[] s = sc.nextLine().split(" ");
		int idx = key.indexOf(s[0]);
		out.print(s[0]);
		for (int i = 1; i < s.length; i++) {
			int shift = Integer.parseInt(s[i]);
			if (shift > 0) --shift;
			else ++shift;
			idx += shift;
			out.print(" " + key.get(idx));
		}
		out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("gleb.dat"));

		key.add("A0"); key.add("B0");
		String[] let = new String[]{"C", "D", "E", "F", "G", "A", "B"};
		for (int i = 1; i <= 7; i++) {
			for (int j = 0; j < 7; j++) key.add(let[j] + i);
		}
		key.add("C8");

		while(sc.hasNextLine()) solve();
	}
}