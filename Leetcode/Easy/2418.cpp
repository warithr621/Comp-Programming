// https://leetcode.com/problems/sort-the-people/?envType=daily-question&envId=2024-07-22

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        // wait hello C++ makes this so easy
        vector< pair<int,string> > pairs;
        for (int i = 0; i < names.size(); i++) {
            pairs.push_back({heights[i], names[i]});
        }
        sort(pairs.rbegin(), pairs.rend());
        vector<string> ans;
        for (auto p : pairs) {
            ans.push_back(p.second);
        }
        return ans;
    }

    vector<string> mapsort(vector<string>& names, vector<int>& heights) {
        // wait hello C++ makes this so easy
        map<int, string> mp;
        for (int i = 0; i < names.size(); i++) {
            mp[heights[i]] = names[i];
        }
        sort(heights.rbegin(), heights.rend());
        vector<string> ans;
        for (int h : heights) ans.push_back(mp[h]);
        return ans;
    }
};