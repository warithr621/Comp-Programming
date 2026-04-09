// https://leetcode.com/problems/dungeon-game/

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n][m];
        // dp[i][j] is the min health needed to reach bottom right
        // with the subgrid from (i,j) to the bottom right corner
        dp[n-1][m-1] = Math.max(1, 1 - dungeon[n-1][m-1]);
        for (int i = n-2; i >= 0; i--) {
            // compute dp[i][m-1]
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - dungeon[i][m-1]);
        }
        for (int j = m-2; j >= 0; j--) {
            // compute dp[n-1][j]
            dp[n-1][j] = Math.max(1, dp[n-1][j+1] - dungeon[n-1][j]);
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                // compute dp[i][j], either from (i+1,j) or from (i,j+1)
                dp[i][j] = Math.max(1,
                    Math.min(
                        dp[i+1][j]-dungeon[i][j], dp[i][j+1]-dungeon[i][j]
                    )
                );
            }
        }
        // for (int[] arr : dp) {
        //     System.out.println(Arrays.toString(arr));
        // }
        return dp[0][0];
    }
}