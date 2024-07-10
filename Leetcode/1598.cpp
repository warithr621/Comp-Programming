// https://leetcode.com/problems/crawler-log-folder/description/?envType=daily-question&envId=2024-07-10

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(vector<string>& logs) {
        int ans = 0;
        for (string s : logs) {
            if (s == "./") continue;
            else if (s == "../") ans = max(--ans, 0);
            else ++ans;
        }
        return ans;
    }
};