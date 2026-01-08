#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MOD = 1'000'000'007;

int pw(int base, int exp) {
	if (exp == 0) return 1;
	base %= MOD;
	int ans = 1;
	while (exp != 0) {
		if (exp & 1) ans = (ans * base) % MOD;
		base = (base * base) % MOD;
		exp >>= 1;
	}
	return ans;
}

signed main() {
	int n,m; cin >> n >> m;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		ans += pw(m, __gcd(i,n));
		ans %= MOD;
	}
	cout << ans * pw(n, MOD-2) % MOD << '\n';
}