// Problem: https://codeforces.com/contest/1840/problem/A

#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
    //code
    int n; cin >> n;
    string s; cin >> s;
    char cur = s[0];
    for (int i = 1; i < n;) {
        if (s[i] == cur) {
            cout << s[i];
            cur = s[i+1];
            i += 2;
        } else ++i;
    }
    cout << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}