// https://leetcode.com/problems/binary-search/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int L = 0, R = nums.size() - 1;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (nums[M] == target) return M;
            if (nums[M] < target) L = ++M;
            else R = --M;
        }
        return -1;
    }
};