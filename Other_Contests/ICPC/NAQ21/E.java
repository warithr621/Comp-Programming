// 2021 NAQ: Eye of Sauron

import java.util.*;

public class E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '(') {
				int left = i;
				int right = s.length() - (i+2);
				if (left == right) System.out.println("correct");
				else System.out.println("fix");
			}
		}
	}
}