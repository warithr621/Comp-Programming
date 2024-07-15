// https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 100005, cursum = 0, L = 0, R = 0;
        // cursum is the sum of all elements in the range [L, R]
        while (R < nums.length) {
            cursum += nums[R];
            R++;
            while (cursum >= target) {
                ans = Math.min(ans, R - L);
                cursum -= nums[L];
                ++L;
            }
        }
        return ans == 100005 ? 0 : ans;
    }
}