// https://leetcode.com/problems/height-checker/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> best;
        for (int x : heights) best.push_back(x);
        sort(best.begin(), best.end());
        int ans = 0;
        for (int i = 0; i < heights.size(); i++) {
            ans += heights[i] != best[i];
        }
        return ans;
    }
};