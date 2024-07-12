// https://leetcode.com/problems/reducing-dishes/submissions/1318282128/
// note: hard problems are actually hard

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        sort(satisfaction.rbegin(), satisfaction.rend());
        int ans = 0, cumulative = 0, poss = 0;
        for (int x : satisfaction) {
            cumulative += x;
            poss += cumulative;
            ans = max(ans, poss);
        }
        return ans;
    }
};