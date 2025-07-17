#include <bits/stdc++.h>
using namespace std;
#define int long long
#define pii pair<int, int>
#define INF (int) 1e15
const int MAXN = 200005;

bool horse[MAXN];
vector<pii> adj[MAXN];
int mdist[2][MAXN];
int rdist[2][MAXN];

void solve() {
	int n, m, h; cin >> n >> m >> h;
	fill(horse, horse + n + 1, false);
	for (int i = 0; i < h; i++) {
		int x; cin >> x;
		horse[x] = true;
	}
	for (int i = 1; i <= n; i++) {
		adj[i].clear();
	}
	for (int i = 0; i < m; i++) {
		int u, v, w; cin >> u >> v >> w;
		adj[u].push_back({v, w});
		adj[v].push_back({u, w});
	}
	// we can use a horse to halve the travel time, but we must use it for the remainder of the time
	// rdist[0][i] is shortest distance w/o horse, [1][i] w/ horse
	// m is from node 1, r is from node n

	auto dijkstra = [&](int start, int dist[2][MAXN]) {
		fill(dist[0], dist[0] + (n+1), INF);
		fill(dist[1], dist[1] + (n+1), INF);
		priority_queue<array<int, 3>, vector<array<int, 3>>, greater<array<int, 3>>> pq;
		dist[0][start] = 0;
		pq.push({0, 0, start}); // {distance, horse_used, node}
		while (!pq.empty()) {
			auto [d, h, u] = pq.top(); pq.pop();
			if (d > dist[h][u]) continue;
			for (auto [v, w] : adj[u]) {
				if (h == 1) {
					// horse is currently being used
					if (d + w/2 < dist[1][v]) {
						dist[1][v] = d + w/2;
						pq.push({dist[1][v], 1, v});
					}
				} else {
					// horse is not being used (yet)
					if (d + w < dist[0][v]) {
						dist[0][v] = d + w;
						pq.push({dist[0][v], 0, v});
					}
					if (d + w/2 < dist[1][v] && horse[u]) {
						dist[1][v] = d + w/2;
						pq.push({dist[1][v], 1, v});

					}
				}
			}
		}
	};
	dijkstra(1, mdist);
	dijkstra(n, rdist);

	int ans = INF;
	for (int i = 1; i <= n; i++) {
		int md = min(mdist[0][i], mdist[1][i]);
		int rd = min(rdist[0][i], rdist[1][i]);
		ans = min(ans, max(md, rd));
		// cout << md << ' ' << rd << '\n';
	}

	cout << (ans == INF ? -1 : ans) << '\n';

}

signed main() {
	int T; cin >> T;
	while (T--) solve();
}