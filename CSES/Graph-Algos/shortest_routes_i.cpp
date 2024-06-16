// CSES Shortest Routes I

#include <bits/stdc++.h>
using namespace std;
#define pii pair<int, int>
#define int long long // I love int overflow
const int MAXN = 100005;
const int inf = (int) 1e18;

int N, M, dist[MAXN], vis[MAXN];
vector< vector<pii> > adj(MAXN, vector<pii>());

signed main() {
	cin >> N >> M;
	while (M --> 0) {
		int A, B, W; cin >> A >> B >> W;
		adj[A].push_back({B, W});
	}

	fill(dist + 1, dist + N + 1, inf);
	fill(vis + 1, vis + N + 1, false);
	dist[1] = 0;
	priority_queue<pii> q;
	q.push({0, 1});
	while(!q.empty()) {
		int node = q.top().second; q.pop();
		if (vis[node]) continue;
		vis[node] = true;
		for (auto p : adj[node]) {
			int dest = p.first, weight = p.second;
			if (dist[node] + weight < dist[dest]) {
				dist[dest] = dist[node] + weight;
				q.push({-dist[dest], dest});
			}
		}
	}

	for (int i = 1; i <= N; i++) cout << dist[i] << ' ';
	cout << '\n';
}