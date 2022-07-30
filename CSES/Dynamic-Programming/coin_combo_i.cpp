// CSES Coin Combinations I

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#define int long long
#define vi vector<int>
#define MOD 1000000007
using namespace std;

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);

	int n,x; cin >> n >> x;
	vi a(n);
	for (int i = 0; i < n; i++) cin >> a[i];
	vi dp(x+1, INT_MAX);
	dp[0] = 0;
	for (int j : a) if (j <= x) dp[j] = 1;
	// for (int i : dp) cout << i << ' ';
	// cout << '\n';
	for (int i = 1; i <= x; i++) {
		for (int j : a) {
			if (i - j >= 0 && dp[i-j] != INT_MAX) {
				dp[i] = (dp[i] == INT_MAX ? dp[i-j] : dp[i] + dp[i-j]);
				if (dp[i] != INT_MAX) dp[i] %= MOD;
			}
		}
		// cout << "Updated dp[" << i << "]\n";
		// for (int k : dp) cout << k << ' ';
		// cout << '\n';
	}
	// for (int i : dp) cout << i << ' ';
	// cout << '\n';
	cout << (dp[x] == INT_MAX ? 0 : dp[x]) << '\n';
}
