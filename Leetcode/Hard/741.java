// https://leetcode.com/problems/cherry-pickup/description/

class Solution {

    static int[][][] dp;
    static int[][] grid;
    static int N;

    static int func(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (N == r1 || N == r2 || N == c1 || N == c2) return -69420;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return -69420;
        if (r1 == N-1 && c1 == N-1) return grid[r1][c1];
        if (dp[r1][c1][c2] != Integer.MIN_VALUE) return dp[r1][c1][c2];
        
        int ans = grid[r1][c1];
        if (c1 != c2) ans += grid[r2][c2];
        ans += Math.max(
            Math.max(
                func(r1, c1 + 1, c2 + 1),
                func(r1 + 1, c1, c2 + 1)
            ), Math.max(
                func(r1 + 1, c1, c2),
                func(r1, c1 + 1, c2)
            )
        );
        dp[r1][c1][c2] = ans;
        return ans;
    }

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        dp = new int[N][N][N];
        for (int[][] mat : dp) {
            for (int[] arr : mat) {
                Arrays.fill(arr, Integer.MIN_VALUE);
            }
        }
        return Math.max(0, func(0,0,0));
    }

}