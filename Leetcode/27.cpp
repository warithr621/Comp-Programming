// https://leetcode.com/problems/remove-element/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (nums.size() == 0) return 0;
        sort(nums.begin(), nums.end());
        int sw = nums.size() - 1;
        while(sw >= 0 && nums[sw] == val) --sw;
        // cout << sw << '\n';
        for (int i = 0; i <= sw; i++) {
            if (nums[i] == val) {
                // cout << i << ' ' << sw << '\n';
                swap(nums[i], nums[sw]);
                while (sw >= 0 && nums[sw] == val) --sw;
            }
        }
        return sw + 1;
    }
};