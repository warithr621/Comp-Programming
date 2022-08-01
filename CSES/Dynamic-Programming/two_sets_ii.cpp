// CSES Two Sets II

#include <iostream>
using namespace std;

int dp[600][130000], MOD = 1000000007;

int main() {
	cin.tie(0)->sync_with_stdio(0);

	int n; cin >> n;
	int req = n * (n+1) / 2;
	if (req & 1) {
		cout << 0;
		return 0;
	}

	req >>= 1;
	dp[0][0] = 1;
	for (int i = 1; i < n; i++) {
		for (int j = 0; j <= req; j++) {
			dp[i][j] += dp[i-1][j];
			if (j >= i) dp[i][j] += dp[i-1][j-i];
			dp[i][j] %= MOD;
		}
	}

	cout << dp[n-1][req] << '\n';
}