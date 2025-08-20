#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n; cin >> n;
	int a[n];
	for (int &x : a) {
		cin >> x;
	}
	int dp[n][n][2];
	// dp[i][j][k] is the max score player k can get
	// when a is used from i to j (inclusive both ends)
	for (int i = 0; i < n; i++) {
		dp[i][i][0] = a[i];
		dp[i][i][1] = 0;
	}
	for (int sz = 2; sz <= n; sz++) {
		for (int i = 0; i + sz - 1 < n; i++) {
			int j = i + sz - 1;
			dp[i][j][0] = max(a[i] + dp[i + 1][j][1], a[j] + dp[i][j - 1][1]);
			dp[i][j][1] = min(dp[i + 1][j][0], dp[i][j - 1][0]);
		}
	}
	cout << dp[0][n - 1][0] << '\n';
}