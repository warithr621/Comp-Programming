#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);

	int c,n; cin >> c >> n;
	vector<int> songs(n);
	for (int &x : songs) {
		cin >> x;
	}
	vector<bitset<1001>> dp(1001);
	// dp[i][j] -> can we have the CDs have i and j mins respectively

	dp[0][0] = true;
	for (int s : songs) {
		if (s > c) continue;
		for (int i = c; i >= 0; i--) {
			dp[i] |= (dp[i] << s); // s on cd 2
			if (i >= s) dp[i] |= dp[i-s]; // s on cd 1
		}
	}
	int best = -1, x = 0, y = 0;
	for (int i = 0; i <= c; i++) {
		for (int j = 0; j <= i; j++) {
			// i > j is forced
			if (!dp[i][j]) continue;
			if (i + j > best || (i+j==best && i-j<x-y)) {
				best = i + j;
				x = i;
				y = j;
			}
		}
	}
	cout << x << ' ' << y << '\n';
}