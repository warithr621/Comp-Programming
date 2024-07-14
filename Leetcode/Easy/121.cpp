// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        cin.tie(0)->sync_with_stdio(0);
        int mn = 1e5, ans = 0;
        for (int x : prices) {
            ans = max(ans, x - mn);
            mn = min(x, mn);
        }
        return ans;
    }
};