// https://leetcode.com/problems/maximum-average-subarray-i/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double cur = 0;
        for (int i = 0; i < k; i++) cur += nums[i];
        double best = cur / k;
        for (int i = k; i < nums.length; i++) {
            cur += nums[i] - nums[i - k];
            best = Math.max(best, cur / k);
        }
        return best;
    }
}