// https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int answer = nums[0], current = 0;
        for (int x : nums) {
            current = Math.max(current + x, x);
            answer = Math.max(answer, current);
        }
        return answer;
    }
}