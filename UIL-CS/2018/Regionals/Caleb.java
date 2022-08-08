// Caleb

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Caleb {
	static Scanner sc;

	static void solve() {
    	String[] s = sc.next().split("/");
    	int M = (int) (Integer.parseInt(s[1]) / 6.0);
    	int H = (int) (Integer.parseInt(s[0]) / 30.0);
    	if (H == 0) H = 12;
    	out.printf("%d:%02d\n", H, M);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("caleb.dat"));
		int T = sc.nextInt();
		while(T-->0) solve();
	}
}