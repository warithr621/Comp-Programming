// Emily

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Emily {
	static Scanner sc;
	
	static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
	static String[] dir = new String[]{"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

	static void solve() {
    	int n = sc.nextInt();
    	int[][] a = new int[n][n];
    	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();
    	sc.nextLine();
    	while(sc.hasNextLine()) {
    	    String s = sc.nextLine();
    	    out.printf("<%s>\n", s);
    	    int cnt = 0;
        	for (int search = 0; search < 8; ++search) {
        	    for (int i = 0; i < n; i++) {
        	        for (int j = 0; j < n; j++) {
        	            //see if we can make 's' starting from (i, j) in the 'search' direction
        	            boolean b = true;
        	            int curi = i, curj = j, len = 0;
        	            while(len < s.length()) {
        	                b &= (s.charAt(len) - '0') == a[curi][curj];
        	                curi = (curi + dx[search] + n) % n;
        	                curj = (curj + dy[search] + n) % n;
        	                ++len;
        	            }
        	            if (b) {
        	                out.printf("(%d,%d) %s\n", i+1, j+1, dir[search]);
        	                ++cnt;
        	            }
        	        }
        	    }
        	}
        	if (cnt == 0) out.println("NOT FOUND");
    	}
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("emily.dat"));
		solve();
	}
}