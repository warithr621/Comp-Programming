// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/?envType=daily-question&envId=2025-05-10

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sumA = 0, zA = 0, sumB = 0, zB = 0;
        for (int x : nums1) {
            sumA += x;
            zA += (x == 0 ? 1 : 0);
        }
        for (int x : nums2) {
            sumB += x;
            zB += (x == 0 ? 1 : 0);
        }
        if (sumA + zA < sumB + zB && zA == 0) return -1;
        if (sumB + zB < sumA + zA && zB == 0) return -1;
        return Math.max(sumA + zA, sumB + zB);
    }
}