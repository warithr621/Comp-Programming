// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/?envType=daily-question&envId=2024-12-28

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] pfx = new int[n+1];
        for (int i = 1; i <= n; i++) pfx[i] = pfx[i-1] + nums[i-1];
        int[][] best = new int[4][n+1], bestIdx = new int[4][n+1];
        for (int i = 1; i <= 3; i++) {
            for (int j = k * i; j <= n; j++) {
                int cur = pfx[j] - pfx[j - k] + best[i - 1][j - k];
                if (cur > best[i][j - 1]) {
                    best[i][j] = cur;
                    bestIdx[i][j] = j - k;
                } else {
                    best[i][j] = best[i][j-1];
                    bestIdx[i][j] = bestIdx[i][j-1];
                }
            }
        }
        int[] ans = new int[3];
        int end = n;
        for (int i = 3; i >= 1; i--) {
            ans[i - 1] = bestIdx[i][end];
            end = ans[i-1];
        }
        return ans;
    }
}