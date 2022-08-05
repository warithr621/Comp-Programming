// Mary

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Mary {
	static Scanner sc;

	static void solve() {
	    int N = sc.nextInt();
	    String[] arr = new String[N];
	    for (int i = 0; i < N; i++) arr[i] = sc.next();
	    String best = ""; int shift = 0;
	    for (int i = 0; i < N/2; i++) {
	        TreeSet<Character> ts = new TreeSet<>();
	        int f = i, s = N - i - 1;
	        for (int j = 0; j < arr[f].length(); j++) for (int k = 0; k < arr[s].length(); k++) {
	            if (arr[f].charAt(j) == arr[s].charAt(k)) ts.add(arr[f].charAt(j));
	        }
	        if (ts.size() == 0) {
	            out.println("IMPOSSIBLE");
	            return;
	        }
	        int tmp = Integer.MAX_VALUE;
	        char apd = 'Z';
	        for (char c : ts) {
	            for (int j = 0; j < arr[f].length(); j++) for (int k = 0; k < arr[s].length(); k++) {
	                if (arr[f].charAt(j) == arr[s].charAt(k) && arr[s].charAt(k) == c) {
	                    int fd = Math.min(j, arr[f].length() - j);
	                    int sd = Math.min(k, arr[s].length() - k);
	                    if (tmp > fd + sd) {
	                        tmp = fd + sd; apd = c;
	                    }
	                }
	            }
	        }
	        best += apd; shift += tmp;
	    }
	    if (N % 2 == 1) best += arr[N/2].charAt(0);
	    
	    out.print(best);
	    for (int i = best.length() - 1 - N%2; i >= 0; i--) out.print(best.charAt(i));
	    out.println(" " + shift);
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("mary.dat"));
		int T = sc.nextInt();
		while(T-->0) solve();
	}
} 