//Problem: https://codeforces.com/contest/1165/problem/A
//Note: Virtual Submission

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n,x,y; cin >> n >> x >> y;
    string s; cin >> s;
    s = s.substr(n-x, x);
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '0' && i == s.length() - y - 1) ++ans;
        if (s[i] == '1' && i != s.length() - y - 1) ++ans;
    }
    cout << ans << '\n';
}