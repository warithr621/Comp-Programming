// https://leetcode.com/problems/range-sum-query-immutable/description/

#include <bits/stdc++.h>
using namespace std;

class NumArray {
public:

    // yay pfx sums
    vector<int> pfx;

    NumArray(vector<int>& nums) {
        pfx.push_back(0);
        for (int i = 0; i < nums.size(); i++) {
            pfx.push_back(pfx[i] + nums[i]);
        }
    }
    
    int sumRange(int left, int right) {
        return pfx[right + 1] - pfx[left];
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */