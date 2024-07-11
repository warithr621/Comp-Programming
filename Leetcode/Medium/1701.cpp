// https://leetcode.com/problems/average-waiting-time/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        double ans = 0;
        int n = customers.size();
        int cur = 1;
        for (const auto& v : customers) {
            cur = max(v[0], cur) + v[1];
            ans += cur - v[0];
        }
        return ans / n;
    }
};

