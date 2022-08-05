// Riley

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Riley {
	static Scanner sc;
    static int R, C;
    static int[][] a, flood;
    static boolean[][] vis;
    
    static void fill(int x, int y, int color) {
        if (x < 0 || x >= R) return;
        if (y < 0 || y >= C) return;
        if (vis[x][y]) return;
        if (flood[x][y] != 0) return;
        if (a[x][y] == 0) return;
        
        vis[x][y] = true;
        flood[x][y] = color;
        fill(x-1, y, color); fill(x+1, y, color);
        fill(x, y-1, color); fill(x, y+1, color);
        fill(x-1, y-1, color); fill(x-1, y+1, color);
        fill(x+1, y-1, color); fill(x+1, y+1, color);
    }
    
	static void solve(int tc) {
	    R = sc.nextInt(); C = sc.nextInt();
	    a = new int[R][C]; flood = new int[R][C]; vis = new boolean[R][C];
	    for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) a[i][j] = sc.nextInt();
	    int color = 1;
	    for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) if (!vis[i][j] && a[i][j] != 0) fill(i, j, color++);
	   // for (int i =0 ; i < R; i++) {
	   //     for (int j = 0; j < C; j++) out.print(flood[i][j] + " "); out.println();
	   // }
	    
	    Double[] sz = new Double[++color];
	    for (int i = 0; i < sz.length; i++) sz[i] = 0.0;
	    for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) {
	        sz[flood[i][j]] += a[i][j] / 4.0;
	    }
	    Arrays.sort(sz, Collections.reverseOrder());
	    double sum = 0;
	    for (int i = 0; i < sz.length; i++) {
	        sum += sz[i];
	       // if (sz[i] != 0) out.printf("%.2f acres\n", sz[i]);
	    }
	    out.printf("%.2f acres\n", sum);
	    for (int i = 0; i < sz.length; i++) {
	        sum += sz[i];
	        if (sz[i] != 0) out.printf("%.2f acres\n", sz[i]);
	    }
	    out.println("============");
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("riley.dat"));
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) solve(i);
	}
} 