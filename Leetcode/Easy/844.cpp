// https://leetcode.com/problems/backspace-string-compare/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool backspaceCompare(string s, string t) {
        stack<char> ss, st;
        for (char c : s) {
            if (c == '#' && !ss.empty()) ss.pop();
            else if (c != '#') ss.push(c);
        }
        for (char c : t) {
            if (c == '#' && !st.empty()) st.pop();
            else if (c != '#') st.push(c);
        }
        return ss == st;
    }

    bool space(string s, string t) {
        // more space-efficient as its O(1) vs O(N)
        // but weirdly despite the same time complexity runs way slower?? 4ms vs 0ms
        int i = s.length() - 1, j = t.length() - 1;
        int ss = 0, st = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s[i] == '#') {
                    ++ss; --i;
                } else if (ss > 0) {
                    --ss; --i;
                } else break;
            }
            while (j >= 0) {
                if (t[j] == '#') {
                    ++st; --j;
                } else if (st > 0) {
                    --st; --j;
                } else break;
            }
            if (i >= 0 && j >= 0 && s[i] != t[j]) return false;
            if ((i >= 0) != (j >= 0)) return false;
            --i; --j;
        }
        return true;
    }
};