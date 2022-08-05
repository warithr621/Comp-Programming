// Alfonso

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Alfonso {
	static Scanner sc;

	static void solve() {
		for (char c = 'A'; c <= 'Z'; c += 4) {
		    for (char i = c; i < 'Z'; i += 2) {
		        for (char j = i; j <= 'Z'; j += 2) out.print(j);
		        out.println();
		    }
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
	    sc = new Scanner(System.in);
// 		sc = new Scanner(new File("alfonso.dat"));
		solve();
	}
} 