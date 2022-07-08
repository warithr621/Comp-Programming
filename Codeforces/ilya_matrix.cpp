// https://codeforces.com/contest/313/problem/C

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
#define int long long
using namespace std;

void solve() {
	int n; cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];
	sort(a.rbegin(), a.rend());
	int ans = 0;
	for (int i = 1; i <= n; i *= 4) {
		ans += accumulate(a.begin(), a.begin()+i, 0);
	}
	cout << ans << '\n';
}

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
	solve();
}
