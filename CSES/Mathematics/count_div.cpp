// CSES Counting Divisors

#include <iostream>
#define int long long
using namespace std;

int max_prime[1000001];

void init() {
	for (int i = 2; i <= 1000000; i++) {
		if (max_prime[i] == 0) {
			for (int j = i; j <= 1000000; j += i) max_prime[j] = i;
		}
	}
}

void solve() {
	int x; cin >> x;
	int ans = 1;
	while (x != 1) {
		int p = max_prime[x];
		int cnt = 0;
		while (x % p == 0) {
			++cnt;
			x /= p;
		}
		ans *= ++cnt;
	}
	cout << ans << '\n';
}

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t;
	init();
	while(t--) solve();
}
