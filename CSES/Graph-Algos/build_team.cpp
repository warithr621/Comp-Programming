// CSES Building Teams

#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<vector<int>> adj;
vector<bool> vis;
vector<int> color;
bool imp = false;

void dfs(int cur, int team=1) {
	if (vis[cur]) return;
	vis[cur] = true;
	color[cur] = team;

	for (int i : adj[cur]) {
	    if (vis[i] && color[i] == team) {
	        imp = true;
	    } else dfs(i, (team == 1 ? 2 : 1)); 
	}
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		adj.push_back(vector<int>());
		vis.push_back(false);
		color.push_back(0);
	}

	for (int i = 0; i < m; i++) {
		int x,y; cin >> x >> y;
		--x; --y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}

	for (int i = 0; i < n; i++) {
		if (!vis[i]) dfs(i);
	}

    if (imp) cout << "IMPOSSIBLE\n";
    else for (int i : color) cout << i << ' ';
}
