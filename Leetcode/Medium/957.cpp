// https://leetcode.com/problems/prison-cells-after-n-days/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        // cycle exists every 14 days
        vector<int> ans(8, 0);
        for (int i = 0; i < 8; i++) ans[i] = cells[i];
        for (int i = 0; i < (n - 1) % 14 + 1; i++) {
            vector<int> tmp(8, 0);
            for (int i = 1; i < 7; i++) {
                if (ans[i-1] == ans[i+1]) tmp[i] = 1;
                else tmp[i] = 0;
            }
            ans = tmp;
        }
        return ans;
    }
};