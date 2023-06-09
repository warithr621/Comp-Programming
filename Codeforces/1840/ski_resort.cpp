// Problem: https://codeforces.com/contest/1840/problem/C

#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
    //code
    int n,k,q; cin >> n >> k >> q;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    vector<int> works;
    for (int i = 0; i < n; i++) {
        if (a[i] <= q) works.push_back(i);
    }
    
    int ans = 0;
    if (works.size() == 0) {
        cout << "0\n";
        return;
    }
    
    // for (int i : works) cout << i << ' ';
    // cout << '\n';
    
    int cur = works[0];
    int len = 1;
    for (int i = 1; i < works.size(); i++) {
        if (works[i] - 1 == cur) {
            ++cur;
            ++len;
        } else {
            cur = works[i];
            if (len >= k) {
                // cout << len << ' ' << k << '\n';
                ans += (len - k + 2) * (1 + len - k) / 2;
            }
            len = 1;
        }
    }
    
    if (len >= k) {
        // cout << len << ' ' << k << '\n';
        ans += (len - k + 2) * (1 + len - k) / 2;
    }
    // cout << '\n';
    cout << ans << '\n';
    
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}