#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int r; cin >> r;
	int t[r];
	for (int &x : t) cin >> x;
	int k; cin >> k;
	int c[k];
	for (int &x : c) cin >> x;
	int m; cin >> m;
	vector<vector<int>> adj(k, vector<int>(k, 100'000));
	for (int i = 0; i < k; i++) adj[i][i] = 0;
	for (int i = 0; i < m; i++) {
		int a,b,d; cin >> a >> b >> d;
		adj[a-1][b-1] = adj[b-1][a-1] = min(adj[a-1][b-1], d);
	}

	// floyd warshall
	for (int z = 0; z < k; z++) {
		for (int x = 0; x < k; x++) {
			for (int y = 0; y < k; y++) {
				adj[x][y] = min(adj[x][y], adj[x][z] + adj[z][y]);
				adj[y][x] = min(adj[y][x], adj[y][z] + adj[z][x]);
			}
		}
	}

	// ugh, dp time
	// make dp[x][y] be min time needed to drink x beers, with last one @ pub y
	vector<vector<int>> dp(r+1, vector<int>(k, 100'000));
	for (int z = 0; z < k; z++) {
		if (adj[0][z] + t[0] <= c[z]) dp[1][z] = adj[0][z] + t[0];
	}
	for (int x = 1; x < r; x++) {
		for (int y = 0; y < k; y++) {
			if (dp[x][y] >= 100'000) continue;
			for (int z = 0; z < k; z++) {
				if (z == y) continue;
				int nt = dp[x][y] + adj[y][z] + t[x];
				if (nt <= c[z]) dp[x+1][z] = min(dp[x+1][z], nt);
			}
		}
	}

	int ans = 0;
	for (int x = 1; x <= r; x++) {
		for (int y = 0; y < k; y++) {
			if (dp[x][y] < 100'000) ans = x;
		}
	}
	cout << ans << '\n';
}