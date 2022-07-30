//Problem: https://codeforces.com/contest/1165/problem/C
//Note: Virtual Submission

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; string s; cin >> n >> s;
    string ans;
    for (int i = 0; i < n; i++) {
        if (ans.size() % 2 == 0 || ans.back() != s[i]) ans += s[i];
    }
    if (ans.size() & 1) ans = ans.substr(0, ans.length()-1);
    cout << (s.size() - ans.size()) << '\n' << ans << '\n';
}