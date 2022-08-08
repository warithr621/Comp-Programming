// Debra

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Debra {
	static Scanner sc;

	static void solve() {
    	String[] tmp = sc.nextLine().split(" ");
    	int R = Integer.parseInt(tmp[0]), C = Integer.parseInt(tmp[1]);
    	char[][] c = new char[R][C];
    	for (int i = 0; i < R; i++) c[i] = sc.nextLine().toCharArray();
    	for (int i = 0; i < R; i++) {
    	    for (int j = c[i].length-1; j >= 0; j--) out.print(c[i][j]);
    	    out.println();
    	}
    	out.println("=====");
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("debra.dat"));
		while(sc.hasNextLine()) solve();
	}
}