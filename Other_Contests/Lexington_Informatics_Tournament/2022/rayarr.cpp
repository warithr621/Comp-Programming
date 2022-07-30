//Source: 2022 Lexington Informatics Tournament Standard Round B (Ray's Arrays)

#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; cin >> n;
    vector<vector<int>> a(n, vector<int>(n));
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) cin >> a[i][j];
    vector<vector<ll>> p(n+1, vector<ll>(n+1, 0));
    for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + a[i-1][j-1];
    auto psum = [&](int x1, int y1, int x2, int y2) {
        // sum from (x1, y1) to (x2, y2) inclusive
        return p[x2+1][y2+1] - p[x1][y2+1] - p[x2+1][y1] + p[x1][y1];
    };
    vector<vector<ll>> dp(n, vector<ll>(n));
    // compute dp[0][0]
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) dp[0][0] += a[i][j] * (i+j);
    // compute dp[i][0]
    for (int i = 1; i < n; i++) dp[i][0] = dp[i-1][0] + psum(0, 0, i-1, n-1) - psum(i, 0, n-1, n-1);
    // compute dp[i][j]
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < n; j++) dp[i][j] = dp[i][j-1] + psum(0, 0, n-1, j-1) - psum(0, j, n-1, n-1);
    }
    ll ans = 1e18;
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) ans = min(ans, dp[i][j]);
    cout << ans << "\n";
    return 0;
}