// https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int jump(vector<int>& nums) {
        // dp soln, approx O(N^2)
        int n = nums.size();
        int dp[n];
        fill(dp, dp + n, (int) 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= i + nums[i] && j < n; j++) {
                dp[j] = min(dp[j], dp[i] + 1);
            }
        }
        // for (int x : dp) cout << x << ' ';
        return dp[n-1];
    }

    int faster(vector<int>& nums) {
        // O(N) solution
        int ans = 0, idx = 0, next, n = nums.size();
        if (n == 1) return 0; // darn edge case
        while (idx < n) {
            // at any point, try to see which option will let you jump furthest in the future
            if (idx + nums[idx] >= n - 1) return ++ans;
            int farthest = 0;
            for (int i = idx + 1; i <= idx + nums[idx]; i++) {
                int jump = i + nums[i];
                if (jump >= farthest) {
                    farthest = jump;
                    next = i;
                }
            }
            idx = next;
            ++ans;
        }
        return ans;
    }
};