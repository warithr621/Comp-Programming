// CSES Book Shop

#include <iostream>
using namespace std;

int dp[1005][100005];
int cost[1005], page[1005];

int main() {
	cin.tie(0)->sync_with_stdio(0);

	int n,x; cin >> n >> x;
	for (int i = 0; i < n; ++i) cin >> cost[i];
	for (int i = 0; i < n; i++) cin >> page[i];

	for (int i = 1; i <= n; i++) {
		int cc = cost[i-1], cp = page[i-1];
		for (int j = 1; j <= x; j++) {
			dp[i][j] = dp[i-1][j];
			if (cc <= j) dp[i][j] = max(dp[i][j], dp[i-1][j-cc] + cp);
		}
	}
	cout << dp[n][x];
}