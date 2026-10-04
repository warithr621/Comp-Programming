#include <bits/stdc++.h>
using namespace std;
#define int long long
#define ld long double

signed main() {
	int t; cin >> t;
	while (t--) {
		int n, p; cin >> n >> p;
		ld a[n];
		for (ld &x : a) {
			cin >> x;
		}
		ld S = accumulate(a, a + n, (ld) 0);
		ld ans = 0;
		for (int x : a) {
			ld tmp = p * (x/S);
			ans += tmp * tmp / x;
		}
		cout << fixed << setprecision(8) << ans << '\n';
	}
	return 0;
}