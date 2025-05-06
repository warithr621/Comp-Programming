// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/?envType=daily-question&envId=2025-04-09

class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] seen = new boolean[100];
        int ans = 0;
        for (int x : nums) {
            if (x < k) return -1;
            if (!seen[x-1] && x != k) ++ans;
            seen[x-1] = true;
        }
        return ans;
    }
}