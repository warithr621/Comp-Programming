// https://codeforces.com/contest/1419/problem/B

import java.util.*;

public class Stairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			long n = sc.nextLong();
			solve(n);
		}
	}

	static void solve(long x) {
		//note how 1, 3, and 7 all work
		/*
		A
		*/
		/*
		  A
		 BB
		CBB
		*/
		/*
		       A
		      BB
		     CBB
		    DDDD
		   EDDDD
		  FFDDDD
		 GFFDDDD
		*/
		//2^1 - 1, 2^2 - 1, 2^3 - 1
		//hmmmmmmmm

		long ans = 0;
		for (int i = 1; triangulate((1L << i) - 1) <= x; i++) {
			++ans;
			x -= triangulate((1L << i) - 1);
		}
		System.out.println(ans);
	}
	static long triangulate (long n) {return n * (n+1) / 2;}
}