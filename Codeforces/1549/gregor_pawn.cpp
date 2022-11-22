//Problem: https://codeforces.com/contest/1549/problem/B

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n; cin >> n;
    char a[n+2], b[n+2];
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= n; i++) cin >> b[i];
    a[0] = b[0] = a[n+1] = b[n+1] = '0';
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (b[i] == '0') continue;
        if (a[i-1] == '1') {
            a[i-1] = '0';
            ++ans;
        } else if (a[i] == '0') {
            ++ans;
        } else if (a[i+1] == '1') {
            a[i+1] = '0';
            ++ans;
        }
    }
    cout << ans << '\n';
}

int main() {
    int t; cin >> t; while(t--) solve();
}
