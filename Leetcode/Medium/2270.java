// https://leetcode.com/problems/number-of-ways-to-split-array/description/?envType=daily-question&envId=2025-01-03

class Solution {
    public int waysToSplitArray(int[] nums) {
        long total = 0;
        for (int x : nums) total += x;
        int ans = 0;
        for (long i = 0, cur = 0; i < nums.length-1; i++) {
            cur += nums[(int)i];
            if (cur >= total - cur) ++ans;
        }
        return ans;
    }
}