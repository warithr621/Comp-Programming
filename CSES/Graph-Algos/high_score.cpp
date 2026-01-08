#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int INF = (int)1e18;

struct Edge {
	int a, b, w;
	Edge(int a, int b, int w) : a(a), b(b), w(w) {}
};

signed main() {
	int N, M; cin >> N >> M;
	vector<Edge> edges;
	vector<vector<int>> radj(N + 1);
	for (int i = 0; i < M; i++) {
		int a, b, w; cin >> a >> b >> w;
		edges.push_back(Edge(a, b, -w));
		radj[b].push_back(a);
	}

	vector<int> d(N+1, INF);
	d[1] = 0;
	for (int i = 1; i < N; i++) {
		for (auto &e : edges) {
			if (d[e.a] < INF && d[e.a] + e.w < d[e.b]) {
				d[e.b] = d[e.a] + e.w;
			}
		}
	}

	vector<bool> bad(N + 1, false);
	for (int i = 1; i <= N; i++) {
		for (auto &e : edges) {
			if (d[e.a] < INF && d[e.a] + e.w < d[e.b]) {
				d[e.b] = d[e.a] + e.w;
				bad[e.b] = true;
			}
		}
	}

	vector<bool> vis(N + 1, false);
	vis[N] = true;
	queue<int> q; q.push(N);
	while (!q.empty()) {
		int u = q.front(); q.pop();
		for (int v : radj[u]) {
			if (!vis[v]) {
				vis[v] = true;
				q.push(v);
			}
		}
	}

	int ans = -d[N];
	for (int i = 1; i <= N; i++) {
		if (bad[i] && vis[i]) {
			ans = -1;
		}
	}
	cout << ans << '\n';
}