// https://leetcode.com/problems/unique-paths-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = obstacleGrid[0][0] ^ 1;
        boolean row, col;
        row = col = (dp[0][0] == 1);
        for (int i = 1; i < n; i++) {
            if (!row) dp[i][0] = 0;
            else {
                dp[i][0] = obstacleGrid[i][0] ^ 1;
                if (dp[i][0] == 0) row = false;
            }
        }
        for (int j = 1; j < m; j++) {
            if (!col) dp[0][j] = 0;
            else {
                dp[0][j] = obstacleGrid[0][j] ^ 1;
                if (dp[0][j] == 0) col = false;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}