#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, m; cin >> n >> m;
	int a[n], b[m];
	for (int &x : a) {
		cin >> x;
	}
	for (int &x : b) {
		cin >> x;
	}
	int dp[n + 1][m + 1];
	memset(dp, 0, sizeof(dp));
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (a[i - 1] == b[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			} else {
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}
	vector<int> lcs;
	int i = n, j = m;
	while (i > 0 && j > 0) {
		if (a[i - 1] == b[j - 1]) {
			lcs.push_back(a[i - 1]);
			i--; j--;
		} else if (dp[i - 1][j] > dp[i][j - 1]) {
			i--;
		} else {
			j--;
		}
	}
	cout << dp[n][m] << '\n';
	reverse(lcs.begin(), lcs.end());
	for (int x : lcs) {
		cout << x << ' ';
	}
	cout << '\n';
}