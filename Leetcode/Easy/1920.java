// https://leetcode.com/problems/build-array-from-permutation/?envType=daily-question&envId=2025-05-06

class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}