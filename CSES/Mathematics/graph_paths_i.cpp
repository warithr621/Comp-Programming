#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = (int) (1e9+7);

vector<vector<int>> mat_mult(const vector<vector<int>>& a, const vector<vector<int>>& b) {
	int n = a.size();
	vector<vector<int>> res(n, vector<int>(n, 0));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				res[i][j] = (res[i][j] + a[i][k] % MOD * b[k][j] % MOD) % MOD;
			}
		}
	}
	return res;
}
vector<vector<int>> mat_pow(const vector<vector<int>>& a, int p) {
	int n = a.size();
	vector<vector<int>> res(n, vector<int>(n, 0));
	for (int i = 0; i < n; i++) {
		res[i][i] = 1; // identity matrix
	}
	vector<vector<int>> base = a;
	while (p > 0) {
		if (p & 1) {
			res = mat_mult(res, base);
		}
		base = mat_mult(base, base);
		p >>= 1;
	}
	return res;
}


signed main() {
	int n, m, k; cin >> n >> m >> k;
	vector<vector<int>> adj(n, vector<int>(n, 0));
	for (int i = 0; i < m; i++) {
		int u, v; cin >> u >> v;
		adj[--u][--v]++;
	}
	// ah now we need to exponentiate this, fun...
	vector<vector<int>> res = mat_pow(adj, k);
	cout << res[0][n-1] << '\n';
}