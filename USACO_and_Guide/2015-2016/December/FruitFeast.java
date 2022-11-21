// 2015 Dec Gold P2

import java.util.*;
import java.io.*;

public class FruitFeast {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// Scanner sc = new Scanner(System.in);
		// PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(new File("feast.in"));
		PrintWriter out = new PrintWriter("feast.out");

		int t = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
		boolean[][] dp = new boolean[t+1][2];
		//dp[i][0] will be true if you can reach 'i' w/o water
		//dp[i][1] will be true if you can reach it w/ water

		//initialize [0][0]
		dp[0][0] = true;

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i <= t; i++) {
				//run dp on waterless, then water
				if (!dp[i][j]) {
					//we can't reach this
					continue;
				}
				//from here on we assume we can reach dp[i]
				if (i + a <= t) {
					//we can reach dp[i+a]
					dp[i+a][j] = true;
				}
				if (i + b <= t) {
					//we can reach dp[i+b]
					dp[i+b][j] = true;
				}
				if (j == 0) {
					//j==0 means we got to dp[i] w/o water
					//meaning we can get to dp[i/2] w/ water
					dp[i/2][j+1] = true;
				}
			}
		}

		int idx = t;
		// for (boolean[] B : dp) out.println(Arrays.toString(B));
		while(!dp[idx][1]) --idx;
		out.println(idx);


		sc.close(); out.close();
	}
}