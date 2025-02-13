// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/?envType=daily-question&envId=2025-02-03

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // the constraints make this VERY easy to do
        // but let's do O(N) instead of O(N^2)
        int inc = 1, dec = 1, mx = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] > nums[i]) {
                ++inc;
                dec = 1;
            } else if (nums[i+1] < nums[i]) {
                ++dec;
                inc = 1;
            } else {
                dec = inc = 1;
            }
            mx = Math.max(mx, Math.max(inc, dec));
        }
        return mx;
    }
}