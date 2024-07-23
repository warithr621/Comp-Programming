// https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            int next = i + (n >> 1);
            if (nums[i] == nums[next]) return nums[i];
        }
        return -1;
    }
    int optimal(vector<int>& nums) {
        // O(N) time as opposed to O(N log N), still only needs O(1) space
        int cnt = 0, ans = 0;
        for (int x : nums) {
            if (cnt == 0) ans = x;
            cnt += (ans == x ? 1 : -1);
        }
        return ans;
        // Moore's Voting Algorithm is very interesting
    }
};