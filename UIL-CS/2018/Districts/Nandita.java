// Nandita

import java.util.*;
import java.io.*;

public class Nandita {
	static Scanner sc;

	static String month(String s) {
		String[] m = new String[]{"", "JANUARY", "FEBRUARY", "MARCH",
			"APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
			"OCTOBER", "NOVEMBER", "DECEMBER"};
		for (int i = 1; i <= 12; i++) if (m[i].equals(s)) {
			return (i < 10 ? "0" : "") + i;
		}
		return "BURRITO";
	}

	static void solve() {
		String[] s = sc.nextLine().split(" ");
		String M = month(s[0]);
		String D = s[1].substring(0, s[1].length()-1);
		if (D.length() == 1) D = "0" + D;
		String Y = s[2];

		System.out.printf("%s/%s/%s\n%s.%s.%s\n%s-%s-%s\n=====\n", 
			M, D, Y.substring(2), D, M, Y, Y, M, D);
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("nandita.dat"));
		while(sc.hasNextLine()) solve();
	}
}