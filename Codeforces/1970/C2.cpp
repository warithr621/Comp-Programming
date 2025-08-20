#include <bits/stdc++.h>
using namespace std;

int n, t, d[200005];
vector<int> adj[200005];

void dfs(int u, int p) {
	if (adj[u].size() == 1 && adj[u][0] == p) {
		// leaf
		d[u] = 1;
		return;
	}
	d[u] = 1;
	for (int v : adj[u]) {
		if (v == p) continue;
		dfs(v, u);
		if (d[v] == 1) {
			d[u] = 0;
			return;
		}
	}
}

int main() {
	cin >> n >> t;
	for (int i = 0; i < n-1; i++) {
		int u, v; cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}

	int start; cin >> start;
	dfs(start, 0);
	cout << (d[start] == 0 ? "Ron" : "Hermione") << '\n';
}