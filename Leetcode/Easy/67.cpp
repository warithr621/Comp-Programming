// https://leetcode.com/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());
        string ans = "";
        int carry = 0, n = a.size(), m = b.size();
        for (int i = 0; i < max(n, m); i++) {
            int v = carry;
            if (i < n) v += a[i] - '0';
            if (i < m) v += b[i] - '0';
            if (v < 2) {
                ans += (char) ('0' + v);
                carry = 0;
            } else {
                ans += (char) ('0' + (v - 2));
                carry = 1;
            }
        }
        if (carry) ans += "1";
        reverse(ans.begin(), ans.end());
        return ans;
    }
};