// CSES Money Sums

#include <iostream>
#include <vector>
#include <algorithm>
#define MAX_N 100000
using namespace std;

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);

	int n; cin >> n;
	vector<int> val(n+1);
	for (int i = 1; i <= n; i++) cin >> val[i];

	bool dp[n+1][MAX_N + 1];
	//dp[i][j] is true if you can make sum 'j' with 'i' coins
	dp[0][0] = true;

	//loop through all coins and sums
		//if you can make a sum with < 'i' coins, dp[i][sum] = true
		//if you can make the sum (curSum - val[i]), dp[i][curSum] = true

	for (int i = 1; i <= n; i++) {
		for (int curSum = 0; curSum <= MAX_N; curSum++) {
			dp[i][curSum] = dp[i-1][curSum];
			int previous = curSum - val[i];
			if (previous >= 0 && dp[i-1][previous]) {
				dp[i][curSum] = true;
			}
		}
	}

	vector<int> possible; //possible sums
	for (int i = 1; i <= MAX_N; i++) {
		if (dp[n][i]) {
			//we can make sum 'i' using at most 'n' coins
			possible.push_back(i);
		}
	}

	cout << possible.size() << '\n';
	for (int i : possible) cout << i << ' ';

	return 0;
}
