// https://leetcode.com/problems/number-of-paths-with-max-score/description/?envType=daily-question&envId=2026-07-05

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = board.get(i);
            for (int j = 0; j < n; j++) {
                if (!Character.isUpperCase(s.charAt(j))) {
                    grid[i][j] = s.charAt(j) - '0';
                } else if (s.charAt(j) == 'X') {
                    grid[i][j] = -1;
                }
            }
        }

        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        dp[n-1][n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            if (dp[i+1][n-1] == -1 || grid[i][n-1] == -1) continue;
            dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1];
        }
        for (int j = n-2; j >= 0; j--) {
            if (dp[n-1][j+1] == -1 || grid[n-1][j] == -1) continue;
            dp[n-1][j] = dp[n-1][j+1] + grid[n-1][j];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if (grid[i][j] == -1) continue;
                if (dp[i+1][j] != -1) dp[i][j] = Math.max(dp[i][j], dp[i+1][j] + grid[i][j]);
                if (dp[i][j+1] != -1) dp[i][j] = Math.max(dp[i][j], dp[i][j+1] + grid[i][j]);
                if (dp[i+1][j+1] != -1) dp[i][j] = Math.max(dp[i][j], dp[i+1][j+1] + grid[i][j]);
            }
        }
        int mx = dp[0][0];
        if (mx == -1) return new int[]{0, 0};

        final int MOD = 1_000_000_007;
        long[][] dp2 = new long[n][n];
        dp2[n-1][n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            if (dp[i+1][n-1] == -1 || grid[i][n-1] == -1) continue;
            if (dp[i][n-1] == dp[i+1][n-1] + grid[i][n-1]) dp2[i][n-1] = dp2[i+1][n-1];
        }
        for (int j = n-2; j >= 0; j--) {
            if (dp[n-1][j+1] == -1 || grid[n-1][j] == -1) continue;
            if (dp[n-1][j] == dp[n-1][j+1] + grid[n-1][j]) dp2[n-1][j] = dp2[n-1][j+1];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if (grid[i][j] == -1 || dp[i][j] == -1) continue;
                long c = 0;
                if (dp[i+1][j] != -1 && dp[i+1][j] + grid[i][j] == dp[i][j]) c += dp2[i+1][j];
                if (dp[i][j+1] != -1 && dp[i][j+1] + grid[i][j] == dp[i][j]) c += dp2[i][j+1];
                if (dp[i+1][j+1] != -1 && dp[i+1][j+1] + grid[i][j] == dp[i][j]) c += dp2[i+1][j+1];
                dp2[i][j] = c % MOD;
            }
        }
        int paths = (int) dp2[0][0];

        return new int[]{mx, paths};
    }
}