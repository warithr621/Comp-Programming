// https://codeforces.com/problemset/problem/1176/E

#include <bits/stdc++.h>
using ll = long long;
using namespace std;

int n, m, color[200005];
vector<int> adj[200005];

void ms(int len) {
	for (int i = 0; i <= len; i++) color[i] = 0;
}

void pront(vector<int> v) {
	cout << v.size() << '\n';
	for (int i : v) cout << i << ' ';
	cout << '\n';
}

void dfs(int pt, int c) {
	if (color[pt]) return;
	color[pt] = 3 - c;
	for (int x : adj[pt]) {
		dfs(x, 3-c);
	}
}

void solve() {
	cin >> n >> m;
	ms(n+2);
	for (int i = 1; i <= n; i++) adj[i] = vector<int>();
	for (int i = 0; i < m; i++) {
		int u,v; cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}

	for (int i = 1; i <= n; i++) {
		// for (int buh = 1; buh <= n; ++buh) cout << color[buh] << ' ';
		// cout << '\n';
		dfs(i, 1);
	}

	vector<int> o, t;
	for (int i = 1; i <= n; i++) {
		if (color[i] == 1) o.push_back(i);
		else t.push_back(i);
	}

	pront(o.size() < t.size() ? o : t);
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}