#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n, m; cin >> n >> m;
	vector<vector<pair<int,int>>> adj(n+1, vector<pair<int,int>>());
	while(m--) {
		int a,b,w; cin >> a >> b >> w;
		adj[a].push_back({-w,b});
		adj[b].push_back({-w,a});
	}
	bool vis[n+1];
	fill(vis+1, vis+n+1, false);
	vis[1] = true;
	int ans = 0;
	priority_queue<pair<int,int>> edges;
	for (auto &p : adj[1]) edges.push(p);
	while (!edges.empty()) {
		auto [weight, dest] = edges.top(); edges.pop();
		if (vis[dest]) continue;
		vis[dest] = true;
		ans -= weight;
		for (auto &p : adj[dest]) edges.push(p);
	}
	for (int i = 1; i <= n; i++) {
		if (!vis[i]) {
			cout << "IMPOSSIBLE\n";
			return 0;
		}
	}
	cout << ans << '\n';
}