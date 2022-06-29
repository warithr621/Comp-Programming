// CSES Divisor Analysis

#include <iostream>
#include <vector>
#define int long long
#define pb push_back
#define MOD 1000000007
using namespace std;

int pow(int base, int exp, int m) {
	if (base == 0) return (exp == 0 ? 1 : 0);
	if (base == 1) return 1;
	base %= m;

	vector<int> pws;
	int cur = base;
	int i = 1;
	for (; i <= exp; i *= 2) {
		pws.pb(cur);
		cur = cur * cur % m;
	}
	i /= 2;
	int curi = (int) pws.size() - 1;
	int ans = 1;

	while(exp != 0) {
		while (i > exp) {
			i /= 2;
			--curi;
		}
		ans = ans * pws[curi] % m;
		exp -= i;
	}
	return ans;
}

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	int a[n][2];
	for (int i = 0; i < n; i++) cin >> a[i][0] >> a[i][1];
	int num = 1;
	for (int i = 0; i < n; i++) num = num * (a[i][1] + 1) % MOD;
	cout << num << ' ';

	int sum = 1;
	for (int i = 0; i < n; i++) {
		int base = a[i][0], exp = a[i][1];
		int temp = pow(base, exp + 1, MOD) - 1;
		int inv = pow(base - 1, MOD - 2, MOD);
		temp = temp * inv % MOD;
		sum = sum * temp % MOD;
	}
	cout << sum << ' ';

	int prod = 1, d = 1;
	for (int i = 0; i < n; i++) {
		int v = pow(a[i][0], a[i][1] * (a[i][1] + 1) / 2, MOD);
		prod = pow(prod, a[i][1] + 1, MOD) * pow(v, d, MOD) % MOD;
		d = d * (a[i][1] + 1) % (MOD - 1);
	}
	cout << prod << '\n';
}