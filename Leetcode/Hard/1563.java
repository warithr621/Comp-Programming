// https://leetcode.com/problems/stone-game-v/?envType=daily-question&envId=2026-08-17

class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] pfx = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pfx[i] = pfx[i-1] + stoneValue[i-1];
        }
        // sum of [l,r] is pfx[r+1] - pfx[l]
        int[][] dp = new int[n][n];
        // dp[i][j] is Alice's max score if the starting array is [i,j]
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = len-1; j < n; i++, j++) {
                // solve for the answer to dp[i][j] by considering all splitting points
                // let's consider all k s.t. we split into [i,k] and [k+1,j]
                int tot = pfx[j+1] - pfx[i];
                for (int k = i; k+1 <= j; k++) {
                    int left = pfx[k+1] - pfx[i], right = tot - left;
                    if (left < right) dp[i][j] = Math.max(dp[i][j], left + dp[i][k]);
                    else if (right < left) dp[i][j] = Math.max(dp[i][j], right + dp[k+1][j]);
                    else {
                        dp[i][j] = Math.max(dp[i][j], 
                            Math.max(left + dp[i][k], right + dp[k+1][j]));
                    }
                }
            }
        }

        return dp[0][n-1];
    }
}