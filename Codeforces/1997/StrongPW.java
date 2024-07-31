// https://codeforces.com/contest/1997/problem/A

import java.io.*;
import java.util.*;

public class StrongPW {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
	    int T = sc.nextInt();
		while (T --> 0) solve();
		sc.close();
	}
	
	public static int time(String s) {
	    int ans = 2;
	    for (int i = 1; i < s.length(); i++) {
	        if (s.charAt(i) == s.charAt(i-1)) ans++;
	        else ans += 2;
	    }
	    return ans;
	}
	
	public static void solve() throws IOException {
	    // solve
	    String s = sc.next();
	    String best = s;
	    int mx = time(best);
	    for (int i = 0; i < s.length(); i++) {
	        char[] test = {'u', 's', 'a'};
	        for (char c : test) {
	            String tst = s.substring(0, i) + c + s.substring(i);
	           // out.println(tst + " " + time(tst));
	            if (time(tst) > mx) {
	                mx = time(tst);
	                best = tst;
	            }
	        }
	    }
	    System.out.println(best);
	}
}