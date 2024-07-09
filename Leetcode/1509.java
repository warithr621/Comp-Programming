// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description/


class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0; // can guaranteed make everything the same value
        // if n == 5, it's just the smallest difference between any pair of numbers, which is O(N)
        // if n == 6, it's the smallest difference between a value and that two higher up in index
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        ans = Math.min(ans, nums[n-1] - nums[3]);
        ans = Math.min(ans, nums[n-2] - nums[2]);
        ans = Math.min(ans, nums[n-3] - nums[1]);
        ans = Math.min(ans, nums[n-4] - nums[0]);
        return ans;
    }
}