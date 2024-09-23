// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/?envType=daily-question&envId=2024-09-14

class Solution {
    public int longestSubarray(int[] nums) {
        int mx = -1;
        for (int x : nums) mx = Math.max(mx, x);
        int ans = 1, cur = 0;
        boolean found = (nums[0] == mx);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mx) {
                if (found) ++cur;
                else {
                    cur = 1;
                    found = true;
                }
            } else {
                if (found) {
                    ans = Math.max(cur, ans);
                    cur = 0;
                }
            }
        }
        return Math.max(ans, cur);
    }
}