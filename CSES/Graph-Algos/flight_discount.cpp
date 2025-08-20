#include <bits/stdc++.h>
using namespace std;
#define int long long
#define pii pair<int,int>
#define f first
#define s second

signed main() {
	int n, m; cin >> n >> m;
	vector<vector<pii>> adj(n+1, vector<pii>());
	for (int i = 0; i < m; i++) {
		int u, v, w; cin >> u >> v >> w;
		adj[u].push_back({v, w});
	}
	vector<vector<int>> dp(n+1, {(int) 1e16, (int) 1e16});
	dp[1] = {0, 0};
	// dp[i][0] is min price of 1->i w/o coupon
	// dp[i][1] is min price of 1->i w/  coupon
	priority_queue<array<int,3>, vector<array<int,3>>, greater<array<int,3>>> pq;
	pq.push({0, 1, 0});
	while (!pq.empty()) {
		auto [c, u, coupon] = pq.top();
		pq.pop();
		if (dp[u][coupon] != c) continue;
		if (u == n) break;
		for (auto &[v, w] : adj[u]) {
			if (!coupon) {
				int nc = c + w/2;
				if (nc < dp[v][1]) {
					dp[v][1] = nc;
					pq.push({nc, v, 1});
				}
			}
			if (c + w < dp[v][coupon]) {
				dp[v][coupon] = c + w;
				pq.push({dp[v][coupon], v, coupon});
			}
		}
	}
	cout << min(dp[n][0], dp[n][1]) << '\n';
}