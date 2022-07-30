// CSES Grid Paths (DP)

#include <iostream>
#define int long long
#define MOD 1000000007
using namespace std;

int32_t main() {
	int n; cin >> n;
	char a[n][n];
	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) cin >> a[i][j];
	int dp[n][n];
	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) dp[i][j] = (i == 0 && j == 0 ? 1 : 0);
	
// 	for (int i = 0; i < n; i++) {for (int j = 0; j < n; j++) cout << dp[i][j] << ' '; cout << '\n';}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (a[i][j] == '*') dp[i][j] = 0;
			else {
				if (i > 0) dp[i][j] += dp[i-1][j];
				if (j > 0) dp[i][j] += dp[i][j-1];
			}
			dp[i][j] %= MOD;
		}
	}
	cout << dp[n-1][n-1] << '\n';
// 	for (int i = 0; i < n; i++) {for (int j = 0; j < n; j++) cout << dp[i][j] << ' '; cout << '\n';}
}
