// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            // easy case:
            if (nums[M] == target) return M;
            if (nums[M] >= nums[L]) {
                if (target >= nums[L] && target < nums[M]) {
                    R = M-1;
                } else {
                    L = M+1;
                }
            } else {
                if (target > nums[M] && target <= nums[R]) {
                    L = M+1;
                } else {
                    R = M-1;
                }
            }
        }
        return -1;
    }
}