// https://leetcode.com/problems/distribute-elements-into-two-arrays-i/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> resultArray(vector<int>& nums) {
        vector<int> fst, sec;
        for (int x : nums) {
            if (fst.empty()) fst.push_back(x);
            else if (sec.empty()) sec.push_back(x);
            else (fst.back() > sec.back() ? fst : sec).push_back(x);
        }
        fst.insert(fst.end(), sec.begin(), sec.end());
        return fst;
    }
};