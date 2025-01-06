// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/?envType=daily-question&envId=2025-01-02

class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 1;
        for (int bit = 1; bit <= 10_000_000; bit <<= 1) {
            int cnt = 0;
            for (int x : candidates) {
                cnt += ((x & bit) != 0 ? 1 : 0);
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}