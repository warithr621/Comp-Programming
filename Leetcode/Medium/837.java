// https://leetcode.com/problems/new-21-game/description/?envType=daily-question&envId=2025-08-17

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n+1];
        dp[0] = 1;
        double seg = Math.min(k, 1);
        for (int i = 1; i <= n; i++) {
            dp[i] = seg / maxPts;
            if (i < k) seg += dp[i];
            if (i - maxPts >= 0 && i - maxPts < k) seg -= dp[i - maxPts];
        }
        double ans = 0;
        for (int i = k; i <= n; i++) ans += dp[i];
        return ans;
    }
}