// https://leetcode.com/problems/missing-number/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int sz = (int) nums.size();
        int ans = 0;
        for (int i = 1; i <= sz; i++) {
            ans ^= i ^ nums[i-1];
        }
        return ans;
    }
};