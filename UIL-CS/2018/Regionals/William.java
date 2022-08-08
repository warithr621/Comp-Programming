// William

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class William {
	static Scanner sc;

	static void solve() {
    	String tmp = sc.next();
    	String f = tmp.substring(0, tmp.length()/2), s = tmp.substring(tmp.length()/2);
    	s = (new StringBuilder().append(s).reverse().toString());
    	int n = f.length(), m = s.length();
    	int dp[][] = new int[n+1][m+1];
    	for (int i = 0; i <= n; i++) {
    	    for (int j = 0; j <= m; j++) {
    	        if (i == 0 || j == 0) dp[i][j] = 0;
    	        else if (f.charAt(i-1) == s.charAt(j-1)) {
    	            dp[i][j] = dp[i-1][j-1] + 1;
    	        } else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    	    }
    	}
    	int len = dp[n][m];
    	char[] best = new char[len--];
    	int i = n, j = m;
    	while(i > 0 && j > 0) {
    	    if (f.charAt(i-1) == s.charAt(j-1)) {
    	        best[len--] = f.charAt(i-1);
    	        --i; --j;
    	    } else if (dp[i-1][j] > dp[i][j-1]) --i;
    	    else --j;
    	}
    	for (i = 0; i < best.length; i++) out.print(best[i]);
    	out.print(":");
    	for (i = best.length-1; i >= 0; i--) out.print(best[i]);
    	out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("william.dat"));
		while(sc.hasNext()) solve();
	}
}