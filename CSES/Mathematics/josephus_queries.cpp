#include <bits/stdc++.h>
using namespace std;

int solve(int n, int k) {
	if (n == 1) return 1;
	if (k <= (n+1)/2) {
		return (2*k <= n ? 2*k : 2*k - n);
	} else {
		return 2 * solve(n/2, k-(n+1)/2) + ((n&1) ? +1 : -1);
	}
}

signed main() {
	int q; cin >> q;
	while (q--) {
		int n, k; cin >> n >> k;
		cout << solve(n, k) << '\n';
	}
}