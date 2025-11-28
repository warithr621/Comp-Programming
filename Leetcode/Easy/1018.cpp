// https://leetcode.com/problems/binary-prefix-divisible-by-5/?envType=daily-question&envId=2025-11-24

class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        vector<bool> ans;
        int cur = 0;
        for (int x : nums) {
            cur = ((cur << 1) + x) % 5;
            ans.push_back(cur == 0);
        }
        return ans;
    }
};