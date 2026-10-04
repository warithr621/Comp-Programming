#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MOD = 1e9 + 7;
const int MAXV = 5000;

int fexp(int base, int exp) {
	int res = 1;
	while (exp) {
		if (exp & 1) res = res * base % MOD;
		base = base * base % MOD;
		exp >>= 1;
	}
	return res;
}

signed main() {
	int n; cin >> n;
	vector<int> xs(n);
	for (int i = 0; i < n; i++) cin >> xs[i];

	vector<int> spf(MAXV + 1); // smallest prime factor
	iota(spf.begin(), spf.end(), 0);
	for (int i = 2; i * i <= MAXV; i++) {
		if (spf[i] == i) {
			for (int j = i * i; j <= MAXV; j += i) {
				if (spf[j] == j) spf[j] = i;
			}
		}
	}

	unordered_map<int, int> index;
	int idx = 0;
	for (int i = 2; i <= MAXV; i++) {
		if (spf[i] == i) index[i] = idx++;
	}
	int m = idx;

	vector<bitset<1024>> vectors(n);
	for (int i = 0; i < n; i++) {
		int x = xs[i];
		bitset<1024> mask;
		while (x > 1) {
			int p = spf[x];
			int cnt = 0;
			while (x % p == 0) {
				x /= p;
				cnt++;
			}
			if (cnt & 1) mask.flip(index[p]);
		}
		vectors[i] = mask;
	}

	vector<bitset<1024>> pivots(m);
	vector<bool> hasPivot(m, false);
	int rank = 0;
	for (int i = 0; i < n; i++) {
		bitset<1024> cur = vectors[i];
		for (int b = m - 1; b >= 0; b--) {
			if (!cur[b]) continue;
			if (hasPivot[b]) {
				cur ^= pivots[b];
			} else {
				pivots[b] = cur;
				hasPivot[b] = true;
				rank++;
				break;
			}
		}
	}

	int ans = fexp(2, n - rank);
	cout << ans << "\n";
}