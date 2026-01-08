#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MAX = 1'000'005;
static const int MOD = 1'000'000'007;

int pbw(int base, int exp) {
	// borrowing the name from irvin atp
	if (exp == 0) return 1;
	base %= MOD;
	int ans = 1;
	while (exp) {
		if (exp & 1) ans = (ans * base) % MOD;
		base = (base * base) % MOD;
		exp >>= 1;
	}
	return ans;
}

int inv(int x) {
	return pbw(x, MOD-2);
}

int ncr(int n, int k) {
	if (k < 0 || k > n) return 0;
	k = min(k, n-k);
	long long num = 1, den = 1;
	for (int i = 1; i <= k; i++) {
		num = num * (n - k + i) % MOD;
		den = den * i % MOD;
	}
	return num * inv(den) % MOD;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	// answer is (k+1) / (n+k+1) times (2n+k choose n)
	// where k is no. of excess open paren
	// and n is remaining pairs
	// so for the sample k = 1 and n = 1

	int len; string s;
	cin >> len >> s;
	if (len & 1) {
		cout << "0\n";
		return 0;
	}
	int k = 0;
	for (char c : s) {
		k += (c == '(' ? 1 : -1);
		if (k < 0) {
			cout << "0\n";
			return 0;
		}
	}
	int n = (len - s.size() - k) / 2;
	cout << (k+1) * inv(n+k+1) % MOD * ncr(2*n+k,n) % MOD;
}