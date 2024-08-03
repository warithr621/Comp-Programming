// https://leetcode.com/problems/minimum-falling-path-sum-ii/description/

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) dp[0][j] = grid[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + grid[i][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x : dp[n-1]) ans = Math.min(ans, x);
        return ans;
    }


    static int[][] mins(int[] arr) {
        int mn = Integer.MAX_VALUE, mnidx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < mn) {
                mn = arr[i];
                mnidx = i;
            }
        }
        int mnmn = Integer.MAX_VALUE, mnmnidx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < mnmn && i != mnidx) {
                mnmn = arr[i];
                mnmnidx = i;
            }
        }
        return new int[][]{ {mn, mnidx}, {mnmn, mnmnidx} };
    }

    public int faster(int[][] grid) {
        // runs in N^2 instead of N^3
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) dp[0][j] = grid[0][j];
        int[][] curmins = mins(dp[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j] + (j != curmins[0][1] ? curmins[0][0] : curmins[1][0]);
            }
            curmins = mins(dp[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int x : dp[n-1]) ans = Math.min(ans, x);
        System.gc();
        return ans;
    }
}