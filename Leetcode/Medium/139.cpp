// https://leetcode.com/problems/word-break/?envType=study-plan-v2&envId=top-interview-150

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();
        bool dp[n+1];
        fill(dp, dp + n+1, false);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (string w : wordDict) {
                int len = w.size();
                if (i - len < 0) continue;
                if (dp[i-len] && s.compare(i-len, len, w) == 0) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
};