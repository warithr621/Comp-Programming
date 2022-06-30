// https://atcoder.jp/contests/dp/tasks/dp_a

#include <iostream>
#include <cmath>
#define int long long
using namespace std;

int32_t main() {
	//dp[1] = hopping from 0 to 1
	//dp[2] = min(hopping from 0 to 2, hopping from 1 to 2
	//	*+ hopping from 0 to 1)
	//dp[i] = min(getting to dp[i-2] + hopping from i-2 to i,
	//	getting to dp[i-1] + hopping from i-1 to i)

	int n; cin >> n;
	int a[n];
	for (int i = 0; i < n; i++) cin >> a[i];
	int dp[n];
	dp[1] = abs(a[0] - a[1]);
	if (n != 2) dp[2] = min(abs(a[0] - a[2]), dp[1] + abs(a[1] - a[2]));
	for (int i = 3; i < n; i++) {
		dp[i] = min(dp[i-1] + abs(a[i-1] - a[i]), dp[i-2] + abs(a[i-2] - a[i]));
	}
	cout << dp[n-1] << '\n';
}