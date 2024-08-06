// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i] is the LIS that ends with nums[i]
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int x : dp) ans = Math.max(ans, x);
        return ans;
    }

    public int faster(int[] nums) {
        // bonus: runs in O(N log N) rather than O(N^2)
        int n = nums.length;
        int[] LIS = new int[n];
        LIS[0] = nums[0];
        int ptr = 1;
        for (int i = 0; i < n; i++) {
            // if we can extend our LIS, do so
            if (LIS[ptr-1] < nums[i]) {
                LIS[ptr++] = nums[i];
            } else {
                // find the first element in LIS that is at least nums[i]
                int idx = Arrays.binarySearch(LIS, 0, ptr, nums[i]);
                if (idx < 0) {
                    idx = -idx - 1;
                    LIS[idx] = nums[i];
                }
                // if idx is more than zero, nums[i] is in LIS already, so nothing to do
            }
        }
        return ptr;
    }
}