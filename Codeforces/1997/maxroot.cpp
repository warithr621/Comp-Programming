// https://codeforces.com/contest/1997/problem/D
// idk why I could just not figure this out in contest

#include <bits/stdc++.h>
using namespace std;
#define int long long
const int INF = 1e9 + 7;

void solve() {
    int n; cin >> n;
    vector<int> a(n);
    for (int& i : a) cin >> i;
    vector<vector<int>> adj(n);
    for (int i = 1; i < n; i++) {
        int p; cin >> p;
        adj[i].push_back(--p);
        adj[p].push_back(i);
    }
    vector<int> vals(n);
    auto dfs = [&](auto&& self, int x, int p) -> void {
        int mn = INF;
        for (int i : adj[x]) {
            if (i == p) continue;
            self(self, i, x);
            mn = min(mn, vals[i]);
        }
        if (mn == INF) vals[x] = a[x];
        else if (a[x] > mn) vals[x] = mn;
        else vals[x] = a[x] + ((mn - a[x]) >> 1);
    };
    dfs(dfs, 0, -1);
    int ans = INF;
    for (int i : adj[0]) ans = min(ans, vals[i]);
    ans += a[0];
    cout << ans << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T--) solve();
}