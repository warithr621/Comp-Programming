// https://codeforces.com/contest/1997/problem/B

import java.io.*;
import java.util.*;

public class MakeThree {
    
    static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	    int T = sc.nextInt();
		while (T --> 0) solve();
		sc.close();
	}
	
	public static void solve() {
	    //solve
	    int N = sc.nextInt(), ans = 0;
	    char[][] arr = new char[2][N];
	    arr[0] = sc.next().toCharArray(); arr[1] = sc.next().toCharArray();
	    for (int i = 0; i < 2; i++) {
	        for (int j = 1; j < N-1; j++) {
	            if (arr[i][j] == 'x') continue;
	            if (i == 0) {
	                ans += (arr[i][j-1] == '.' && arr[i][j+1] == '.' && arr[i+1][j] == '.' && arr[i+1][j-1] == 'x' && arr[i+1][j+1] == 'x' ? 1 : 0);
	            } else {
	                ans += (arr[i][j-1] == '.' && arr[i][j+1] == '.' && arr[i-1][j] == '.' && arr[i-1][j-1] == 'x' && arr[i-1][j+1] == 'x' ? 1 : 0);
	            }
	        }
	    }
	    System.out.println(ans);
	}
}