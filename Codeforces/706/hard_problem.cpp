// https://codeforces.com/contest/706/problem/C

%:include <bits/stdc++.h>
#define int long long
const int mx = 2e18 + 13;
using namespace std;

signed main() <%
	int n; cin >> n;
	vector<vector<int>> c(n, vector<int>(2));
	for (int i = 0; i < n; i++) cin >> c[i][1], c[i][0] = 0;
	vector<vector<string>> a(n, vector<string>(2));
	for (int i = 0; i < n; i++) {
		cin >> a[i][0];
		a[i][1] = a[i][0];
		reverse(a[i][1].begin(), a[i][1].end());
	}

	int dp[n][2];

	dp[0][0] = 0; dp[0][1] = c[0][1];
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < 2; j++) {
			dp[i][j] = mx;
			for (int k = 0; k < 2; k++) {
				if (a[i][j] >= a[i-1][k]) {
					dp[i][j] = min(dp[i][j], dp[i-1][k] + c[i][j]);
				}
			}
		}
	}

	int ans = min(dp[n-1][0], dp[n-1][1]);
	cout << (ans == mx ? -1 : ans) << '\n';
%>