// https://leetcode.com/problems/group-anagrams/
#include <bits/stdc++.h>

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> f;
        for (string s : strs) {
            string key = s;
            sort(key.begin(), key.end());
            if (f.find(key) == f.end())f[key] = {s};
            else f[key].push_back(s);
        }
        vector< vector<string> > ans;
        for (auto i : f) ans.push_back(i.second);
        return ans;
    }
};