// https://leetcode.com/problems/find-peak-element/?envType=study-plan-v2&envId=top-interview-150

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int N = nums.size();
        if (N == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[N-1] > nums[N-2]) return N-1;
        int L = 1, R = N-2;
        while (L < R) {
            int M = (L + R) >> 1;
            if (nums[M] > nums[M-1] && nums[M] > nums[M+1]) return M;
            if (nums[M] < nums[M+1]) L = ++M;
            else R = --M;
        }
        return L;
    }
};