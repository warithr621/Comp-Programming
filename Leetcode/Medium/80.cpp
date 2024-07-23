// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int N = nums.size(), L = 2, R = 2;
        if (N < 2) return N;
        while (R < N) {
            if (nums[L-2] != nums[R]) {
                nums[L++] = nums[R];
            }
            ++R;
        }
        return L;
    }
};