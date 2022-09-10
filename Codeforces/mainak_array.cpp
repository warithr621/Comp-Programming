// https://codeforces.com/contest/1726/problem/A

#include <bits/stdc++.h>
#define int long long
using namespace std;

void solve() {
	int n; cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	int ans = a[n-1] - a[0]; //assume this
	for (int i = 0; i < n-1; i++) {
		ans = max(ans, a[i] - a[i+1]); //cycshift the whole thing
	}
	for (int i = 1; i < n; i++) {
		ans = max(ans, a[i] - a[0]); //cycshift everything but a[0]
	}
	for (int i = 0; i < n; i++) {
		ans = max(ans, a[n-1] - a[i]); //cycshift everything but a[n-1]
	}

	cout << ans << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);

	int T; cin >> T;
	while(T--) solve();
}