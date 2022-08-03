// CSES Tree Diameter

#include <bits/stdc++.h>
using namespace std;

int N, dist, point;
vector<int> adj[300000];

void dfs(int u, int p, int d) {
	for (int v : adj[u]) {
		if (v == p) continue;
		dfs(v, u, d+1);
	}
	if (d > dist) {
		dist = d;
		point = u;
	}
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> N;
	for (int i = 1; i < N; i++) {
		int x,y; cin >> x >> y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}

	dfs(1, -1, 0);
	dist = 0;
	dfs(point, -1, 0);
	cout << dist << '\n';
}