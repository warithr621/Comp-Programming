// CSES Bracket Sequence I

#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = (int) 1e9+7;

int fexp(int a, int b, int m = MOD) {
	a %= m;
    int ans = 1;
    while (b > 0) {
        if (b & 1)
            ans = ans * a % m;
        a = a * a % m;
        b >>= 1;
    }
    return ans;
}

int inv(int x, int m = MOD) {
	return fexp(x, m - 2, m);
}

signed main() {
	// apparently these are Catalan numbers??
	// which is C_n = (2n)! / ( (n!)^2 * (n+1) )
	// which is also (2n)! / ( (n)! * (n+1)! )
	int n; cin >> n;
	if (n % 2 == 1) {
		cout << "0\n";
		return 0;
	}
	n >>= 1;
	int ans = 1;
	for (int i = n+1; i <= 2 * n; i++)
		ans = ans * i % MOD;
	for (int i = 2; i <= n+1; i++)
		ans = ans * inv(i) % MOD;
	cout << ans << '\n';
}