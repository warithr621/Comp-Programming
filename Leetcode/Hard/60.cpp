// https://leetcode.com/problems/permutation-sequence/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int fact(int x) {
        return (x <= 1 ? 1 : x * fact(x-1));
    }
    string getPermutation(int n, int k) {
        int find = k - 1;
        string ans = "";
        vector<int> unvis;
        for (int i = 1; i <= n; i++) unvis.push_back(i);
        for (int i = n, cur = fact(n); i > 0; i--) {
            cur /= i;
            int idx = find / cur;
            find %= cur;
            ans += to_string(unvis[idx]);
            unvis.erase(unvis.begin() + idx);
        }
        return ans;
    }
};