#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n; cin >> n;
	int a[n];
	for (int &i : a) cin >> i;
	int s, f; cin >> s >> f;
	// wait surely this is fine the best window of length f-s, right
	int cur = 0;
	for (int i = s-1; i < f-1; i++) {
		cur += a[i];
	}
	int best = cur, ans = 1, start = s-1;
	// cout << best << ' ' << ans << '\n';
	for (int t = 2; t <= n; t++) {
		cur -= a[(start + (f-s) - 1) % n];
		start = (start - 1 + n) % n;
		cur += a[start];
		if (cur > best) {
			best = cur;
			ans = t;
		}

	}
	cout << ans << '\n';
}