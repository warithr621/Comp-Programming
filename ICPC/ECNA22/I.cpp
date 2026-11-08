#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

const int INF = 1e18;

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	// i think this is just dijkstra no?

	int n, m, a, b; cin >> n >> m >> a >> b;
	vector<vector<pair<int, int>>> adj(n);
	for (int i = 0; i < m; i++) {
		int u,v,w; cin >> u >> v >> w;
		--u; --v;
		adj[u].push_back({v,w});
		adj[v].push_back({u,w});
	}

	vector<int> ijk1(n, INF), ijk2(n, INF);
	auto dijkstra = [&](int start, vector<int>& dist) {
		priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
		dist[start] = 0;
		pq.push({0, start});
		while (!pq.empty()) {
			auto [d, u] = pq.top(); pq.pop();
			if (d > dist[u]) continue;
			for (auto [v, w] : adj[u]) {
				if (dist[v] > d + w) {
					dist[v] = d + w;
					pq.push({dist[v], v});
				}
			}
		}
	};
	dijkstra(a-1, ijk1);
	dijkstra(b-1, ijk2);
	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (auto [j, w] : adj[i]) {
			if (ijk1[i] + w + ijk2[j] != ijk1[b-1] && ijk1[j] + w + ijk2[i] != ijk1[b-1]) {
				ans += w;
			}
		}
	}
	cout << (ans>>1) << '\n';
}