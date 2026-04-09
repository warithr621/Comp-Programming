#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MOD = 1e9 + 7;

void solve() {
	int N; cin >> N;
	vector<pair<int, int>> tree(N+1, {-1, -1});
	for (int i = 1; i <= N; i++) {
		int L, R; cin >> L >> R;
		if (L != 0) {
			tree[i] = {L, R};
		}
	}
	vector<int> dp(N+1, 0);
	function<void(int)> dfs = [&](int node) {
		auto [f, s] = tree[node];
		if (f == -1) {
			dp[node] = 1;
			return;
		}
		dfs(f); dfs(s);
		dp[node] = (dp[f] + dp[s] + 3) % MOD;
	};
	dfs(1);
	vector<int> dp2(N+1, 0);
	function<void(int)> dfs2 = [&](int node) {
		auto [f, s] = tree[node];
		dp2[node] = (dp2[node] + dp[node]) % MOD;
		if (f != -1) {
			dp2[f] = (dp2[f] + dp2[node]) % MOD;
			dfs2(f);
			dp2[s] = (dp2[s] + dp2[node]) % MOD;
			dfs2(s);
		}
	};
	dfs2(1);
	for (int i = 1; i <= N; i++) {
		cout << dp2[i] << ' ';
	}
	cout << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}