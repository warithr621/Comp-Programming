// https://codeforces.com/contest/1992/problem/B

#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
    int n, k; cin >> n >> k;
    vector<int> a(k);
    for (int i = 0; i < k; i++) cin >> a[i];
    sort(a.begin(), a.end());
    int ans = 0;
    for (int i = 0; i < k-1; i++) ans += a[i]-1;
    cout << ans + ans + k - 1 << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}