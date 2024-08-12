// https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k %= n;
        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            ans[i] = nums[(i - k + n) % n];
        }
        nums = ans;
    }
};