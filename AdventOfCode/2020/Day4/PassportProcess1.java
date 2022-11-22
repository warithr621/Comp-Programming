// AoC 2020 D4

import java.util.*;
import java.io.*;

public class PassportProcess1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		int ans = 0;
		String tmp = "";
		while(sc.hasNextLine()) tmp += sc.nextLine() + " ";
		String[] arr = tmp.split("  ");
		// for (String str : arr) System.out.println(str);

		String[] test = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", 
			"ecl", "pid", "cid"};

		for (String str : arr) {
			ArrayList<String> al = new ArrayList<>(
			Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", 
			"ecl", "pid", "cid"));

			for (String s : test) {
				if (str.contains(s)) al.remove(s);
			}
			if (al.size() == 0 || al.size() == 1 && al.get(0).equals("cid")) {
				++ans;
			}

		}

		System.out.println(ans);
	}
}