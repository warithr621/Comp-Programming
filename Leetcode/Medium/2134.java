// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/?envType=daily-question&envId=2024-08-02

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] pfx = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            pfx[i] = pfx[i-1] + nums[(i-1) % n];
        }
        int k = pfx[n]; // sum of ones = number of ones
        // k and not "ones" just because nice letter
        int ans = -1;
        for (int i = 0; i < n; i++) {
            // starting at i, find the sum of sequence length "k"
            ans = Math.max(ans, pfx[i + k] - pfx[i]);
        }
        return k - ans;
    }
}