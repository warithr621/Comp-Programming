// https://leetcode.com/problems/burst-balloons/?envType=problem-list-v2&envId=plakya4j

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        // dp[i][j] = ans for subarray [i,j]
        for (int sz = 1; sz <= n; sz++) {
            for (int i = 0; i + sz - 1 < n; i++) {
                int j = i + sz - 1;
                int left = (i - 1 >= 0) ? nums[i - 1] : 1;
                int right = (j + 1 < n) ? nums[j + 1] : 1;

                int best = 0;
                for (int k = i; k <= j; k++) {
                    int cur = left * nums[k] * right;
                    if (k > i) cur += dp[i][k - 1];
                    if (k < j) cur += dp[k + 1][j];
                    best = Math.max(best, cur);
                }
                dp[i][j] = best;
            }
        }
        // for (int[] arr : dp) {
        //     System.out.println(Arrays.toString(arr));
        // }

        return dp[0][n - 1];
    }
}