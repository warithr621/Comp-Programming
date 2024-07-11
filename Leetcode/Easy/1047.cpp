// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string removeDuplicates(string s) {
        stack<char> st;
        for (char c : s) {
            if (!st.empty() && st.top() == c) st.pop();
            else st.push(c);
        }
        string ans = "";
        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        // fun fact it's way faster to do this than "ans = st.top() + ans" and avoid reversal
        // like as in 346 ms versus 16 ms
        return ans;
    }
};