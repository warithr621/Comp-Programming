// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/?envType=daily-question&envId=2026-08-11

class Solution {
public:
    int missingInteger(vector<int>& nums) {
        vector<bool> exists(51, false);
        for (int x : nums) exists[x] = true;
        int sum = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i-1] + 1) sum += nums[i];
            else break;
        }
        while (sum <= 50 && exists[sum]) ++sum;
        return sum;
    }
};