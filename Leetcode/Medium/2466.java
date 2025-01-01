// https://leetcode.com/problems/count-ways-to-build-good-strings/?envType=daily-question&envId=2024-12-30

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = (dp[i] + dp[i - zero]) % MOD;
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % MOD;
        }
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        return ans;
    }
}