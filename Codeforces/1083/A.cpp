#include <bits/stdc++.h>
using namespace std;
#define int long long
#define pii pair<int, int>
const int MAXN = 300005;

int w[MAXN], dp[MAXN][2];
vector<vector<pii>> adj(MAXN, vector<pii>());

void dfs(int cur, int prev) {
	for (auto &[dest, weight] : adj[cur]) {
		if (dest == prev) continue;
		dfs(dest, cur);
		int v = dp[dest][0] - weight;
		if (v > dp[cur][1]) dp[cur][1] = v;
		if (dp[cur][1] > dp[cur][0]) swap(dp[cur][0], dp[cur][1]);
	}
	dp[cur][0] += w[cur];
}


signed main() {
	int n; cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> w[i];
	}
	for (int i = 1; i < n; i++) {
		int u, v, c; cin >> u >> v >> c;
		adj[u].push_back({v, c});
		adj[v].push_back({u, c});
	}
	dfs(1, -1);
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		// cout << dp[i][0] << ' ' << dp[i][1] << '\n';
		ans = max(ans, dp[i][0] + dp[i][1]);
	}
	cout << ans << '\n';
}