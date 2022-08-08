// Micaela

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Micaela {
	static Scanner sc;

	static void solve() {
	    String[] tmp = sc.nextLine().split(" ");
	    String s = tmp[0], t = tmp[1];
	    int n = s.length(), m = t.length();
	    int[][] len = new int[n+1][m+1];
	    for (int i = 0; i <= n; i++) {
	        for (int j = 0; j <= m; j++) {
	            if (i == 0 || j == 0) len[i][j] = 0;
	            else if (s.charAt(i-1) == t.charAt(j-1)) {
	                len[i][j] = len[i-1][j-1] + 1;
	            } else {
	                len[i][j] = Math.max(len[i-1][j], len[i][j-1]);
	            }
	        }
	    }
	    int cur = len[n][m];
	    if (cur == 0) {out.println("NONE"); return;}
	    char[] back = new char[cur];
	    int i = n, j = m;
	    while(i > 0 && j > 0) {
	        if (s.charAt(i-1) == t.charAt(j-1)) {
	            back[cur-1] = s.charAt(i-1);
	            --i; --j; --cur;
	        } else if (len[i-1][j] > len[i][j-1]) --i;
	        else --j;
	    }
	    for (char c : back) out.print(c);
	    out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("micaela.dat"));
		while(sc.hasNextLine()) solve();
	}
} 