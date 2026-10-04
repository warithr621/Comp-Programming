#include <bits/stdc++.h>
using namespace std;
#define int long long

vector<int> v, parent, in, out;
vector<vector<int>> adj;

struct Fenwick {
	vector<int> bit; int n;
	Fenwick(int n) {
		this->n = n;
		bit.assign(n, 0);
	}
	int sum(int r) {
		int ret = 0;
		for (; r >= 0; r = (r & (r + 1)) - 1)
			ret += bit[r];
		return ret;
	}
	int sum(int l, int r) {
		return sum(r) - sum(l - 1);
	}
	void add(int idx, int delta) {
		for (; idx < n; idx = idx | (idx + 1))
			bit[idx] += delta;
	}
};

signed main() {
	int n, q; cin >> n >> q;
	v.resize(n);
	for (int &x : v) {
		cin >> x;
	}
	adj.resize(n);
	for (int i = 1; i < n; i++) {
		int u,v; cin >> u >> v;
		u--; v--;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	for (int i = 0; i < n; i++) {
		sort(adj[i].begin(), adj[i].end());
	}
	in = out = parent = vector<int>(n, -1);
	int vis = 0;
	auto dfs = [&](auto self, int u, int p) -> void {
		parent[u] = p;
		in[u] = vis++;
		for (int v : adj[u]) {
			if (v == p) continue;
			self(self, v, u);
		}
		out[u] = vis-1;
	};
	dfs(dfs, 0, -1);
	Fenwick fw(n);
	for (int i = 0; i < n; i++) {
		fw.add(in[i], v[i]);
	}
	while (q--) {
		int t; cin >> t;
		if (t == 1) {
			int u, x; cin >> u >> x;
			u--;
			fw.add(in[u], x - v[u]);
			v[u] = x;
		} else {
			int u; cin >> u;
			u--;
			cout << fw.sum(in[u], out[u]) << '\n';
		}
	}
}