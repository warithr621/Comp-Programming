// https://leetcode.com/problems/3sum/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector< vector<int> > ans;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int req = -nums[i];
            int L = i+1, R = n-1;
            while (L < R) {
                if (nums[L] + nums[R] == req) {
                    vector<int> push = {nums[i], nums[L], nums[R]};
                    ans.push_back(push);
                    while (L < R && nums[L] == nums[L+1]) ++L;
                    while (L < R && nums[R] == nums[R-1]) --R;
                    ++L; --R;
                } else if (nums[L] + nums[R] < req) ++L;
                else --R;
            }
        }
        return ans;
    }
};