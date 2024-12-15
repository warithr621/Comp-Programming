// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/?envType=daily-question&envId=2024-12-11

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int L = 0, R = 0; L < nums.length && R < nums.length; ) {
            // in every iteration, we have the subarray [L, R]
            if (nums[R] - nums[L] <= 2 * k) {
                ans = Math.max(ans, R - L + 1);
                ++R;
            } else {
                ++L;
            }
        }
        return ans;
    }
}