// CSES Minimizing Coins

#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

#define int long long

using namespace std;

int32_t main() {
	int n,x; cin >> n >> x;
	vector<int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];
	vector<int> dp(x+1, INT_MAX);
	dp[0] = 0;
	for (int i = 0; i <= x; i++) {
		for (int j : a) {
			if (i - j >= 0) dp[i] = min(dp[i], dp[i-j] + 1);
		}
		// cout << "Finished updating dp[" << i << "].\n";
		// for (int k = 0; k <= x; k++) cout << dp[k] << ' ';
		// cout << "\n\n";
	}
	cout << (dp[x] == INT_MAX ? -1 : dp[x]) << '\n';
}
