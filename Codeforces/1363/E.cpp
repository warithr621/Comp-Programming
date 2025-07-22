// darn had to peak at edi a bit, graphs too hard

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define pii pair<int, int>
const int MAXN = 200005;

int n, cost = 0, a[MAXN], b[MAXN], c[MAXN];
vector<int> adj[MAXN];

pii dfs(int u, int p, int mn) {
	pii tot = {0, 0};
	if (b[u] ^ c[u]) {
		if (b[u] == 0) tot.first++;
		else tot.second++;
	}
	for (auto v : adj[u]) {
		if (v == p) continue;
		pii res = dfs(v, u, min(mn, a[u]));
		tot = {tot.first + res.first, tot.second + res.second};
	}
	// cout << u << ' ' << tot.first << ' ' << tot.second << '\n';
	// cout << a[u] << ' ' << mn << '\n';
	if (a[u] < mn) {
		int v = min(tot.first, tot.second);
		cost += 2 * v * a[u];
		tot.first -= v;
		tot.second -= v;
	}
	return tot;
}

signed main() {
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i] >> b[i] >> c[i];
	}
	for (int i = 1; i < n; i++) {
		int u, v; cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	// if you can shuffle k nodes at some u, you can shuffle at parent[u] too
	// so modify the a values accordingly
	// then essentially it's just "oh balance it as much as possible
		// and then send rest of stuff to parent"
	auto res = dfs(1, 0, (int) 4e9);
	if (res.first != 0 or res.second != 0) {
		cout << "-1\n";
	} else {
		cout << cost << '\n';
	}
}