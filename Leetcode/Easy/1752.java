// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/?envType=daily-question&envId=2025-02-02

class Solution {

    private boolean works(int[] arr, int start) {
        int n = arr.length;
        for (int i = start; i + 1 < n; i++) {
            if (arr[i] > arr[i+1]) return false;
        }
        if (start != 0 && arr[n-1] > arr[0]) return false;
        for (int i = 0; i + 1 < start; i++) {
            if (arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    public boolean check(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (works(nums, i)) return true;
        }
        return false;
    }
}