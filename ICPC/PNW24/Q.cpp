#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

const int MOD = 998'244'353;

int fexp(int b, int e) {
	e %= (MOD - 1);
	int ans = 1;
	while (e) {
		if (e & 1) ans = ans * b % MOD;
		b = b * b % MOD;
		e >>= 1;
	}
	return ans;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n,k,p; cin >> n >> k >> p;
	// you have k weeks, each week you pick p problems from a set of n
	// find P(2 weeks share a problem)
	// aka 1 - P(every week is unique)
	// if p * k > n, pigeonhole forces it to be 1 - 0
	if (p * k > n) {
		cout << "1\n";
		return 0;
	}
	// in our made up sample, we have 3 weeks
	// each week we pick 2 from 10 problems
	// ans is like [10c2 / 10c2] * [8c2 / 10c2] * [6c2 / 10c2] or smth
	// well [xcp / ncp], given x <= n, is
	// x! * (n-p)! / [(x-p)! * n!]
	// ig you precomp the factorials and then simulate?
	vector<int> fact(n+1), invfact(n+1);
	fact[0] = 1;
	for (int i = 1; i <= n; i++) fact[i] = fact[i-1] * i % MOD;
	invfact[n] = fexp(fact[n], MOD - 2);
	for (int i = n-1; i >= 0; i--) invfact[i] = invfact[i+1] * (i+1) % MOD;

	int ans = 1;
	for (int i = 0; i < k; i++) {
		int x = n - i * p;
		ans = ans * fact[x] % MOD * fact[n-p] % MOD;
		ans = ans * invfact[x-p] % MOD * invfact[n] % MOD;
	}

	// now remember this is the complement of the answer
	ans = (1 - ans + MOD) % MOD;
	cout << ans << '\n';	
}