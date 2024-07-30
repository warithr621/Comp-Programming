// https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] + nums[nums.length - i - 1]);
        }
        return ans / 2.0;
    }
}