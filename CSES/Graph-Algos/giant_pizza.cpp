#include <bits/stdc++.h>
using namespace std;
#define pb push_back

vector<int> adj[200'005], rev[200'005];
vector<int> order, comp;
vector<bool> vis;

int conv(int var, bool want) {
	return 2 * (var-1) + want;
} // -1 = 0, +1 = 1, -2 = 2, +2 = 3, ...

void add(int x, int y) {
	adj[x].pb(y);
	rev[y].pb(x);
}

void dfs1(int n) {
	vector<pair<int,int>> stack; // (node, edge index)
	stack.pb({n, 0});
	vis[n] = true;
	while (!stack.empty()) {
		auto &[u, idx] = stack.back();
		if (idx < adj[u].size()) {
			int v = adj[u][idx++];
			if (!vis[v]) {
				vis[v] = true;
				stack.pb({v, 0});
			}
		} else {
			order.pb(u);
			stack.pop_back();
		}
	}
}

void dfs2(int n, int id) {
	vector<int> stack;
	stack.pb(n);
	vis[n] = true;
	comp[n] = id;
	while (!stack.empty()) {
		int u = stack.back();
		stack.pop_back();
		for (int v : rev[u]) {
			if (!vis[v]) {
				vis[v] = true;
				comp[v] = id;
				stack.pb(v);
			}
		}
	}
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, m; cin >> n >> m;
	vis.assign(m << 1, false);
	comp.assign(m << 1, -1);
	for (int i = 0; i < n; i++) {
		int a, b; char ca, cb;
		cin >> ca >> a >> cb >> b;
		int alpha = conv(a, ca == '+');
		int beta = conv(b, cb == '+');
		add(alpha ^ 1, beta);
		add(beta ^ 1, alpha);
	}
	for (int i = 0; i < (m << 1); i++) {
		if (!vis[i]) dfs1(i);
	}
	fill(vis.begin(), vis.end(), false);
	int id = 0;
	for (int i = (m << 1)-1; i >= 0; i--) {
		int u = order[i];
		if (!vis[u]) dfs2(u, id++);
	}

	// "will it work"
	for (int i = 1; i <= m; i++) {
		if (comp[conv(i, true)] == comp[conv(i, false)]) {
			cout << "IMPOSSIBLE\n";
			return 0;
		}
	}
	for (int i = 1; i <= m; i++) {
		bool val = comp[conv(i, true)] > comp[conv(i, false)];
		cout << (val ? '+' : '-') << ' ';
	}
}