// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int n = nums.length;
        if (Math.min(nums[0], nums[n-1]) < nums[1] && nums[1] < Math.max(nums[0], nums[n-1])) {
            return nums[0];
        }

        int l = 0, r = n-1;
        int mn = Math.min(nums[0], nums[n-1]);
        int mx = nums[0] + nums[n-1] - mn;
        while (l < r) {
            int m = (l + r) / 2;
            if (r - l == 1) {
                if (nums[l] > nums[r]) return nums[r];
                else return nums[r+1];
            }
            // either bigger than both, or smaller than both
            if (nums[m] > mx) {
                l = m;
            } else {
                r = m-1;
            }
        }
        // l should be the max value
        return nums[l+1]; // shouldn't out of bounds
    }
}