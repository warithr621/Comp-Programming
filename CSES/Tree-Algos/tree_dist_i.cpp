#include <bits/stdc++.h>
using namespace std;

int main() {
	int n; cin >> n;
	vector<vector<int>> adj(n+1, vector<int>());
	for (int i = 1; i < n; i++) {
		int u, v; cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	// dfs from 1 to find diameter endpoint
	auto dfs = [&](auto self, int u, int p) -> pair<int,int> {
		pair<int,int> res = {0, u};
		for (int v : adj[u]) {
			if (v == p) continue;
			auto tmp = self(self, v, u);
			tmp.first++;
			res = max(res, tmp);
		}
		return res;
	};
	auto [tmp, alpha] = dfs(dfs, 1, -1);
	// dfs from endpoint to find other endpoint
	auto [tmp2, beta] = dfs(dfs, alpha, -1);

	// now run the distance dfses from both of these
	vector<int> da(n+1), db(n+1);
	auto dfs2 = [&](auto self, int u, int p, vector<int>& d) -> void {
		for (int v : adj[u]) {
			if (v == p) continue;
			d[v] = d[u] + 1;
			self(self, v, u, d);
		}
	};
	dfs2(dfs2, alpha, -1, da);
	dfs2(dfs2, beta, -1, db);

	for (int i = 1; i <= n; i++) {
		cout << max(da[i], db[i]) << ' ';
	}
}