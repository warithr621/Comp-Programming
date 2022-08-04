// Max

import java.util.*;
import java.io.*;

public class Max {
	static Scanner sc;

	static void solve() {
		String[] letters = new String[]{"Alpha", "Bravo", "Charlie", 
			"Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliet",
			"Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", 
			"Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey",
			"Xray", "Yankee", "Zulu"
		};
		String[] nums = new String[]{"Zero", "Wun", "Too", "Tree", "Fower",
			"Fife", "Six", "Seven", "Ait", "Niner"
		};

		char[] c = sc.next().toCharArray();
		for (char ch : c) {
			if (ch <= '9') System.out.print(nums[ch - '0'] + " ");
			else S3ystem.out.print(letters[ch - 'A'] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("max.dat"));
		while(sc.hasNext()) solve();
	}
}