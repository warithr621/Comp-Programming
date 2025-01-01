// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid

class Solution {
    public int maxMoves(int[][] grid) {
        // surely this is just O(MN) dp
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m-1; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = -1; k <= 1; k++) {
                    int ni = i + k, nj = j + 1;
                    if (0 <= ni && ni < n && grid[ni][nj] > grid[i][j] && dp[i][j] == j) {
                        dp[ni][nj] = Math.max(dp[ni][nj], dp[i][j] + 1);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}