// https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); // just in case it's not alr sorted
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (c > i) break;
                if (dp[i - c] == -1) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
            if (dp[i] == Integer.MAX_VALUE) dp[i] = -1;
        }
        return dp[amount];
    }
}