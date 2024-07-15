// https://leetcode.com/problems/house-robber/?envType=study-plan-v2&envId=top-interview-150

class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        pair<int, int> dp[n];
        for (int i = 0; i < n; i++) {
            dp[i] = {i, nums[i]};
            for (int j = 0; j < i-1; j++) {
                if (dp[j].second + nums[i] > dp[i].second) {
                    dp[i] = {i, dp[j].second + nums[i]};
                }
            }
        }

        int ans = 0;
        for (auto p : dp) ans = max(ans, p.second);
        return ans;
    }
};