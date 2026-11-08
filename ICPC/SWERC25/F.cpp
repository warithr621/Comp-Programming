#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int t; cin >> t;
	while (t--) {
		int n; cin >> n;
		vector<int> v(n), row(n, -1), col(n, -1);
		for (int i = 0; i < n; i++) {
			cin >> v[i];
		}
		for (int i = 0; i < n-1; i++) {
			// use v[i] and v[i+1]
			if (v[i+1] > v[i]) {
				// same row!
				row[i] = row[i+1] = (v[i+1] - v[i]);
				col[i] = v[i] / row[i];
				col[i+1] = v[i+1] / row[i+1];
			} else {
				// loops over, so v[i+1] is col 1 of a row
				col[i+1] = 1;
				row[i+1] = v[i+1];
				row[i] = row[i+1] - 1;
				col[i] = v[i] / row[i];
			}
		}
		int ans = 0;
		for (int x : row) ans = max(x, ans);
		for (int x : col) ans = max(x, ans);
		cout << ans << '\n';
	}
}