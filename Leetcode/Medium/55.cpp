// https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int mv = 0;
        for (int x : nums) {
            if (mv < 0) return false;
            if (x > mv) mv == x;
            --mv;
        }
        return true;
    }
};