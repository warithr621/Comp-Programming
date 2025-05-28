// HOLY CLUTCH WITH 3 MINS LEFT

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
#include <queue>
using namespace std;

const int INF = 2e9 + 2;

void solve() {
    int n, m, l; cin >> n >> m >> l;
    vector<int> a(l);
    int smodd = INF;
    int s = 0;
    for (int i = 0; i < l; i++) {
        cin >> a[i];
        if (a[i] % 2 == 1) {
            smodd = min(smodd, a[i]);
        }
        s += a[i];
    }
    sort(a.begin(), a.end());

    vector<vector<int>> g(n, vector<int>());
    for (int i = 0; i < m; i++) {
        int u, v; cin >> u >> v;
        --u; --v;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    vector<vector<int>> dp(n, vector<int>(2, INF));
    dp[0][0] = 0;
    queue<pair<int, int>> q;
    q.push({0, 0});
    while (q.size()) {
        auto [cur, depth] = q.front();
        q.pop();
        for (auto dest : g[cur]) {
            if (dp[dest][!depth] > dp[cur][depth] + 1) {
                dp[dest][!depth] = dp[cur][depth] + 1;
                q.push({dest, !depth});
            }
        }
    }

    for (int i = 0; i < n; i++) {
        int yay = 0;
        for (int d = 0; d < 2; d++) {
            int ss = s - (d == s % 2 ? 0 : smodd);
            if (dp[i][d] <= ss) yay = 1;
        }
        cout << yay;
    }
    cout << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T--) solve();
}