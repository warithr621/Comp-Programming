// Hyun

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Hyun {
	static Scanner sc;
	
	static String number = "1234567890", top = "qwertyuiop", home = "asdfghjkl", bottom = "zxcvbnm";

	static void solve(int tc) {
		String s = sc.nextLine();
		out.printf("Case #%d: ", tc);
		boolean[] b = new boolean[4];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') continue;
			b[0] |= number.indexOf(c) != -1;
			b[1] |= top.indexOf(c) != -1;
			b[2] |= home.indexOf(c) != -1;
			b[3] |= bottom.indexOf(c) != -1;
		}
		if (b[0]) out.print("NUMBER ");
		if (b[1]) out.print("TOP ");
		if (b[2]) out.print("HOME ");
		if (b[3]) out.print("BOTTOM ");
		out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("hyun.dat"));
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= T; i++) solve(i);
	}
} 
