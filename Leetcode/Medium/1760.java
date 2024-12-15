// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/?envType=daily-question&envId=2024-12-07

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // trivial binary search??
        int L = 1, R = 0;
        for (int x : nums) R = Math.max(R, x);
        while (L < R) {
            int M = (L + R) >> 1;
            if (check(M, nums, maxOperations)) R = M;
            else L = ++M;
        }
        return L;
    }

    private boolean check(int M, int[] nums, int maxOperations) {
        int tot = 0;
        for (int x : nums) {
            tot += Math.ceil(x / 1. / M) - 1;
            if (tot > maxOperations) return false;
        }
        return true;
    }
}