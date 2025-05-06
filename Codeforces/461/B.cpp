#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100005, MOD = 1e9 + 7;

vector<int> adj[MAXN];
int n, a[MAXN];
long long dp[MAXN][2];

long long binexp(long long base, long long power) {
	base %= MOD;
	if (base == 0) return (power == 0 ? 1 : 0);
	if (base == 1 or power == 0) return 1;
	if (power == 1) return base;
	long long ans = 1;
	while (power > 0) {
		if (power & 1) {
			ans = ans * base % MOD;
		}
		base = base * base % MOD;
		power >>= 1;
	}
	return ans;
}

void dfs(int src) {
	long long val = 1;
	for (int &dest : adj[src]) {
		dfs(dest);
		val = val * (dp[dest][0] + dp[dest][1]) % MOD;
	}
	if (a[src] == 0) {
		dp[src][0] = val;
		for (int &dest : adj[src]) {
			dp[src][1] = (dp[src][1] + val * binexp(dp[dest][0] + dp[dest][1], MOD-2) % MOD * dp[dest][1]) % MOD;
		}
	} else {
		dp[src][0] = 0;
		dp[src][1] = val;
	}
}

int main() {
	cin >> n;
	for (int i = 1; i < n; i++) {
		int u; cin >> u;
		adj[u].push_back(i);
	}
	for (int i = 0; i < n; i++) cin >> a[i];
	dfs(0);
	cout << dp[0][1] << '\n';
}