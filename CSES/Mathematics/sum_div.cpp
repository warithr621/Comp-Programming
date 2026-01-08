#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MOD = 1'000'000'007;
static const int INV2 = (MOD+1)>>1;

int brute(int n) {
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		ans += (n/i) * i % MOD;
		ans %= MOD;
	}
	return ans;
}

int optimized(int n) {
	int ans = 0;
	int start = 1;
	while (start <= n) {
		int freq = n / start;
		int last = n / freq;
		ans += (last - start + 1) % MOD * ((start + last) % MOD) % MOD * INV2 % MOD * (freq % MOD) % MOD;
		ans %= MOD;
		start = ++last;
	}
	return ans;
}

signed main() {
	int n; cin >> n;
	cout << optimized(n) << '\n';
}