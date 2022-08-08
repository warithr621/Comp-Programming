// Ariana

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Ariana {
	static Scanner sc;

	static void solve() {
    	String[] words = new String[]{"i", "must", "not", "tell", "lies."};
    	for (int i = 1; i <= 40; i++) {
    	    out.print(i + (i < 10 ? " " : "") + " ");
    	    int pos = (i - 1) % 8;
    	    if (pos >= 4) pos = -pos + 8;
    	    for (int j = 0; j < 5; j++) {
    	        if (pos == j) out.print(words[j].toUpperCase());
    	        else out.print(words[j]);
    	        out.print(" ");
    	    }
    	    out.println();
    	}
	}

	public static void main(String[] args) throws FileNotFoundException {
	    sc = new Scanner(System.in);
// 		sc = new Scanner(new File("ariana.dat"));
		solve();
	}
}