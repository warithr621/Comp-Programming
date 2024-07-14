// https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int L = 0, R = 1;
        while (R < (int) nums.size()) {
            if (nums[L] == nums[R]) ++R;
            else nums[++L] = nums[R];
        }
        return ++L;
    }
};