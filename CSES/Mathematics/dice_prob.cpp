#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n, a, b; cin >> n >> a >> b;
	vector<vector<double>> dp(n+1, vector<double>(6*n+1, 0));
	dp[0][0] = 1;
	// dp[c][s] is no. of ways to sum s with c dice
	for (int die = 1; die <= n; die++) {
		for (int start = 0; start <= 6*n; start++) {
			for (int end = start+1; end <= start+6 and end <= 6*n; end++) {
				dp[die][end] += dp[die-1][start];
			}
		}
		for (int j = 0; j <= 6*n; j++) {
			dp[die][j] /= 6;
			// cout << die << ' ' << j << ' ' << dp[die][j] << '\n';
		}
	}
	double ans = 0;
	for (int i = a; i <= b; i++) ans += dp[n][i];
	stringstream ss;
	ss << fixed << setprecision(6) << ans;
	cout << ss.str() << '\n';
}