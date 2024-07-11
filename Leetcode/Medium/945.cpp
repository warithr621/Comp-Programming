// https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int ans = 0, cur = 0;
        for (int x : nums) {
            ans += max(cur - x, 0);
            cur = max(cur, x) + 1;
        }
        return ans;
    }
};