// https://leetcode.com/problems/predict-the-winner/description/

class Solution {
    public boolean predictTheWinner(int[] nums) {
        // isn't this N^2 dp?
        int n = nums.length;
        int[][] dp = new int[n][n];
        // dp[i][j] is the max diff Player 1 can get on the subarray [i,j]
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length <= n; i++) {
                int j = i + length - 1;
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
                // System.out.println(i + " " + j);
            }
        }
        return dp[0][n-1] >= 0;
    }
}

