// https://leetcode.com/problems/maximum-score-from-removing-substrings/?envType=daily-question&envId=2024-07-12

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumGain(string s, int x, int y) {
        int ans = 0;
        stack<char> st;
        string remove = (x > y ? "ab" : "ba");
        for (char c : s) {
            if (!st.empty() && st.top() == remove[0] && c == remove[1]) {
                ans += max(x,y);
                st.pop();
            } else st.push(c);
        }
        string tmp = "";
        while (!st.empty()) {
            tmp += st.top(); st.pop();
        }
        // cout << ans << ' ' << tmp << '\n';
        reverse(tmp.begin(), tmp.end());
        remove = (x > y ? "ba" : "ab");
        for (char c : tmp) {
            if (!st.empty() && st.top() == remove[0] && c == remove[1]) {
                ans += min(x,y);
                st.pop();
            } else st.push(c);
        }
        return ans;
    }
};