// https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150

class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        int L = 0, R = 0, n = nums.size(), sz = 0;
        vector<string> ans;
        if (n == 0) return ans; // i hate edge cases
        while (R < n) {
            // see if we can add nums[R] to our sequence
            if (nums[R] == nums[L] + sz) {
                // all good, nothing much to do
                ++R;
                ++sz;
            } else {
                --R;
                // now our range is [L, R]
                string interval = to_string(nums[L]);
                if (L != R) interval += "->" + to_string(nums[R]);
                ans.push_back(interval);
                sz = 0;
                L = ++R;
            }
        }
        // gotta do this one more time darn
        --R;
        string interval = to_string(nums[L]);
        if (L != R) interval += "->" + to_string(nums[R]);
        ans.push_back(interval);
        return ans;
    }
};