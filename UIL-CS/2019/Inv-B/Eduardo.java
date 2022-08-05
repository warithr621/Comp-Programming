// Eduardo

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Eduardo {
	static Scanner sc;

	static void solve() {
		String[] s = sc.nextLine().split(" ");
		int shift = s[0].length();
		for (String str : s) {
		    for (int i = 0; i < str.length(); i++) {
		        int let = str.charAt(i) - 'a';
		        let = (let + shift) % 26;
		        out.print((char) (let + 'a'));
		    }
		    out.print(' ');
		}
		out.println();
		
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("eduardo.dat"));
		while(sc.hasNextLine()) solve();
	}
} 