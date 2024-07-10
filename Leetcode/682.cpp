// https://leetcode.com/problems/baseball-game/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int> st;
        for (string s : operations) {
            if (s == "C") st.pop();
            else if (s == "D") st.push(2 * st.top());
            else if (s == "+") {
                int x = st.top(); st.pop();
                int y = st.top(); st.pop();
                st.push(y); st.push(x); st.push(x + y);
            } else st.push(stoi(s));
            // DEBUG
            // stack<int> tmp;
            // while (!st.empty()) {
            //     cout << st.top() << ' ';
            //     tmp.push(st.top());
            //     st.pop();
            // }
            // cout << "e\n" << flush;
            // while (!tmp.empty()) {
            //     st.push(tmp.top());
            //     tmp.pop();
            // }
            // cout << s << '\n' << flush;
            // END OF DEBUG
        }
        int ans = 0;
        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }
        return ans;
    }
};