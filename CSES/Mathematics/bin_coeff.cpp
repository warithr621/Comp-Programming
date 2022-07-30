// CSES Binomial Coefficients

#include <iostream>
#define int long long
#define MOD 1000000007
using namespace std;

int fact[1000001], inv[1000001];

int pow(int base, int exp, int m) {
	if (base == 0) return (exp == 0 ? 1 : 0);
	if (base == 1) return 1;
	base %= m;
 
	int ans = 1;
	while (exp > 0) {
	    if (exp % 2 == 1) ans = ans * base % m;
	    base = base * base % m;
	    exp >>= 1;
	}
	
	return ans;
}

void pre_fact() {
	fact[0] = 1;
	for (int i = 1; i <= 1000000; i++) fact[i] = fact[i-1] * i % MOD;
}

void pre_inv() {
	inv[0] = 1;
	for (int i = 1; i <= 1000000; i++) inv[i] = pow(fact[i], MOD-2, MOD);
}

void solve() {
	int n,k; cin >> n >> k;
	cout << fact[n] * inv[k] % MOD * inv[n-k] % MOD << '\n';
}

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
	pre_fact(); pre_inv(); //precomputations
	int t; cin >> t;
	while(t--) solve();
}
