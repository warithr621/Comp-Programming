// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/

class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        if (n == 1) return target[0];
        if (n == 2) return Math.max(target[0], target[1]);
        long ans = target[0] + target[n-1];
        for (int i = 0; i < n-1; i++) {
            ans += (long) Math.abs(target[i] - target[i+1]);
        }
        return (int) (ans >> 1L);
        // although the answer is guaranteed to fit in an int
        // 2 times it is not
    }
}