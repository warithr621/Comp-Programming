// Stelios

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Stelios {
	static Scanner sc;

	static void solve() {
	    String[] s = sc.nextLine().split(" ");
	    int n = Integer.parseInt(s[0]);
	    int[][] dist = new int[n][n];
	    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) dist[i][j] = 123456;
	    for (int i = 1; i < s.length; i++) {
	        int u = s[i].charAt(0) - 'A', v = s[i].charAt(1) - 'A';
	        dist[u][v] = dist[v][u] = 1;
	    }
	    for (int k = 0; k < n; k++) {
	        for (int i = 0; i < n; i++) {
	            for (int j = i+1; j < n; j++) {
	               // out.printf("%d->%d->%d vs %d->%d\nOption 1: %d\nOption 2: %d\n\n", i, k, j, i, j, dist[i][k]+dist[k][j], dist[i][j]);
	                if (dist[i][k] + dist[k][j] < dist[i][j]) {
	                    dist[i][j] = dist[j][i] = dist[i][k] + dist[k][j];
	                }
	            }
	        }
	    }
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            if (i == j || dist[i][j] == 123456) out.print("0 ");
	            else out.print(dist[i][j] + " ");
	        }
	        out.println();
	    }
	    for (int i = 0; i < 2*n-1; i++) out.print("-");
	    out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("stelios.dat"));
		while(sc.hasNextLine()) solve();
	}
} 