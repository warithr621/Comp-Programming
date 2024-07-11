// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/?envType=daily-question&envId=2024-07-11

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string reverseParentheses(string s) {
        stack<char> st;
        for (char c : s) {
            if (c != ')') {
                // either '(' or a letter, just push it in
                st.push(c);
            } else {
                // we found a '(', so now we need to pop a bunch and push it in reverse
                queue<char> q;
                while (st.top() != '(') {
                    q.push(st.top());
                    st.pop();
                }
                st.pop(); // remove the '('
                while (!q.empty()) {
                    st.push(q.front());
                    q.pop();
                }
            }
        }
        string ans = "";
        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }

    string fast(string s) {
    	// this takes advantage of C++'s reverse() to speed it up
    	// as well as reduce memory requirement
        stack<int> st;
        string ans = "";
        for (char c : s) {
            if (c == '(') st.push(ans.length());
            else if (c == ')') {
                int cur = st.top(); st.pop();
                reverse(ans.begin() + cur, ans.end());
            } else ans += c;
        }
        return ans;
    }

    string faster(string s) {
    	// I read this in the editorial and would've never thought of this
    	// but this basically treats () pairs as "teleporters" to solve this in O(N)
        int n = s.length();
        int teleport[n];
        stack<int> st;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') st.push(i);
            if (s[i] == ')') {
                int r = st.top(); st.pop();
                teleport[i] = r;
                teleport[r] = i;
            }
        }
        string ans = "";
        for (int i = 0, dir = 1; i < n; i += dir) {
            if (s[i] == '(' || s[i] == ')') {
                i = teleport[i];
                dir = -dir;
            } else ans += s[i];
        }
        return ans;
    }
};