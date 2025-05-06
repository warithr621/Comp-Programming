// CSES Tree Matching

#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200005;

int n;
int L[MAXN];
vector<int> adj[MAXN];
int jump[21][MAXN];

void dfs(int src, int prev, int l) {
	jump[0][src] = prev;
	L[src] = l;
	for (int dest : adj[src]) {
		if (dest != prev) dfs(dest, src, l+1);
	}
}

void preprocess() {
	dfs(1, -1, 0);
	for (int i = 1; 1 << i <= n; i++) {
		for (int j = 0; j <= n; j++) jump[i][j] = jump[i-1][jump[i-1][j]];
	}
}

int lca(int p, int q) {
	if (L[p] < L[q]) swap(p, q);
	int diff = L[p] - L[q];
	for (int i = 20; i >= 0; i--) {
		if (diff & (1 << i)) p = jump[i][p];
	}
	if (p == q) return p;
	for (int i = 20; i >= 0; i--) {
		if (jump[i][p] != jump[i][q]) {
			p = jump[i][p];
			q = jump[i][q];
		}
	}
	return jump[0][p];
}

int main() {
	int q; cin >> n >> q;
	for (int i = 0; i < n-1; i++) {
		int u,v; cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	preprocess();
	while (q--) {
		int a,b; cin >> a >> b;
		cout << L[a] + L[b] - 2 * L[lca(a,b)] << '\n';
	}
}