// Prashant

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Prashant {
	static Scanner sc;

    static long[] fact = new long[17];
    static void pf() {
        fact[0] = fact[1] = 1L;
        for (int i = 2; i < 17; i++) fact[i] = fact[i-1] * i;
    }

	static void solve() {
    	String[] s = sc.nextLine().split(" ");
    	long ans = fact[s.length];
    	char[] f = new char[26];
    	for (int i = 0; i < s.length; i++) f[s[i].charAt(0) - 'A']++;
    	for (int i = 0; i < 26; i++) ans /= fact[f[i]];
    	out.println(ans);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("prashant.dat"));
		pf(); while(sc.hasNextLine()) solve();
	}
}