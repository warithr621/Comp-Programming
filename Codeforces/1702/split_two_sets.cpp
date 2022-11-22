// https://codeforces.com/problemset/problem/1702/E

#include <bits/stdc++.h>
using namespace std;
#define pii pair<int, int>
#define vi vector<int>
#define pb push_back

int n, c[200005];
pii d[200005];
vi g[200005], nb[200005];
bool yay = true;

void dfs(int v, int color) {
	if (c[v] == color) return;
	if (c[v] == -1) c[v] = color;
	if (c[v] != color) {
		yay = false;
		return;
	}
	for (int u : g[v]) {
		dfs(u, !color);
		if (!yay) return;
	}
}

void solve() {
	cin >> n;
	yay = true;
	for (int i = 0; i < n; i++) {
		g[i].clear(); nb[i].clear();
	}

	for (int i = 0; i < n; i++) {
		int a,b; cin >> a >> b;
		d[i].first = --a, d[i].second = --b;
		nb[a].pb(i); nb[b].pb(i);
	}

	bool sz = false;
	for (int i = 0; i < n; i++) {
		sz |= ((int) nb[i].size() != 2);
	}
	if (sz) {
		cout << "no\n";
		return;
	}


	for (int i = 0; i < n; i++) {
		int a = d[i].first, b = d[i].second;
		if (nb[a][0] == i) swap(nb[a][0], nb[a][1]);
		if (nb[b][0] == i) swap(nb[b][0], nb[b][1]);

		g[i].pb(nb[a][0]);
		g[i].pb(nb[b][0]);
	}

	fill(c, c+n, -1);
	for (int i = 0; i < n; i++) {
		if (!yay) break;
		if (c[i] == -1) dfs(i, 0);
	}
	cout << (yay ? "yEs\n" : "NO\n");
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}