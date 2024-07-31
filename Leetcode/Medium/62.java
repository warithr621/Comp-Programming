// https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        // thanks to comp math this is super easy formulaically
        // the answer is simply (n + m - 2) choose (n - 1)
        // however due to number constraints this won't work unless I use BigInteger (annoying)
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}