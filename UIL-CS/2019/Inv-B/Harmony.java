// Harmony

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Harmony {
	static Scanner sc;

	static void solve() {
		String s = sc.next();
		out.print(s + " ");
		int len = s.length(), check = s.charAt(len-1) - '0';
		int odd = 0, even = 0;
		for (int i = 1; i < len; i++) {
		    if (i % 2 == 1) odd += s.charAt(i-1) - '0';
		    else even += s.charAt(i-1) - '0';
		}
		int high = 0;
		for (int i = 1; i < len; i+= 2) {
		    if (s.charAt(i-1) > '4') ++high;
		}
		int sum = odd * 3 + even + high;
		int req = (sum % 10 == 0 ? 0 : 10 - sum % 10);
		if (req == check) out.println("VALID");
		else out.printf("INVALID %d\n", req);
// 		out.printf("Check = %d, Req = %d, Sum = %d\n", check, req, sum);
// 		out.println(odd + " " + even + " " + high);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("harmony.dat"));
		int T = sc.nextInt();
		while(T-->0) solve();
	}
} 