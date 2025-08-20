#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
	int N; cin >> N;
	vector<int> W(N+1);
	for (int i = 1; i <= N; i++) {
		cin >> W[i];
	}
	vector<vector<int>> adj(N+1);
	for (int i = 1; i < N; i++) {
		int u, v; cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	vector<int> add;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j < adj[i].size(); j++) {
			add.push_back(W[i]);
		}
	}
	sort(add.rbegin(), add.rend());
	int best = accumulate(W.begin(), W.end(), 0LL);
	cout << best;
	for (int &x : add) {
		cout << ' ' << (best += x);
	}
	cout << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) solve();
}