// Fa

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Fa {
	static Scanner sc;

	static void solve() {
	    int n = sc.nextInt();
	    int[] a = new int[n];
	    for (int i = 0; i < n; i++) a[i] = sc.nextInt();
	    int[] pfx = new int[n+1];
	    for (int i = 1; i <= n; i++) pfx[i] = pfx[i-1] + a[i-1];
	    String best = ""; int diff = 123456;
	    for (double pos = 1.5; pos < n; pos += 0.5) {
	        //pos = position of fulcrum
	            //if pos is whole number, fulcrum on whole
	            //otherwise it's between the two ints (2.5 -> 2^3)
	        int left = 0, right = 0;
	        if ((int) pos == pos) {
	            //pos is a whole number
	            left = pfx[(int)pos-1];
	            right = pfx[n] - pfx[(int)pos];
	        } else {
	            //pos is a decimal
	            left = pfx[(int)pos];
	            right = pfx[n] - pfx[(int)pos];
	        }
	       // out.printf("%.1f %d %d\n", pos, left, right);
	       if (Math.abs(right - left) < diff) {
	            diff = Math.abs(right-left);
	            if ((int)pos == pos) {
	                best = String.format("%d ^%d %d", left, (int) pos - 1, right);
	            } else {
	                best = String.format("%d %d^%d %d", left, (int) pos - 1, (int) pos, right);
	            }
	        }
	    }
	    out.println(best);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("fa.dat"));
		while(sc.hasNextInt()) solve();
	}
} 