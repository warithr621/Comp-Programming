#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t;
	while (t--) {
		int n,a,b,x,y; cin >> n >> a >> b >> x >> y;
		if (n <= x) {
			cout << a * n << '\n';
			continue;
		}
		n -= x;
		int ans = a * x;
		int chunks = n / (x + y);
		ans += max(b * (y+x), a * x) * chunks;
		n %= (x + y);
		ans += max(b * n, a * max(0LL, n-y));
		cout << ans << '\n';
	}
}