#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = 998244353;
const int MAXN = 100000;
using rect = pair<int, int>;
int fact[MAXN + 1];
vector<rect> poss(const rect& r) {
	auto [l, s] = r;
	if (l == s) return {{l, s}};
	else return {{l, s}, {s, l}};
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	fact[0] = 1;
	for (int i = 1; i <= MAXN; i++) {
		fact[i] = fact[i - 1] * i % MOD;
	}
	int t; cin >> t;
	while (t--) {
		int n; cin >> n;
		vector<rect> a(n);
		for (auto& [l, s] : a) {
			int x, y; cin >> x >> y;
			l = max(x, y);
			s = min(x, y);
		}
		sort(a.rbegin(), a.rend());
		bool done = false;
		for (int i = 1; i < n && !done; i++) {
			if (a[i].second > a[i-1].second) {
				done = true;
			}
		}
		if (done) {
			cout << "0\n";
			continue;
		}

		vector<rect> prev = poss(a[0]);
		vector<int> dp(prev.size(), 1);
		for (int i = 1; i < n; i++) {
			vector<rect> cur = poss(a[i]);
			vector<int> ndp(cur.size(), 0);
			for (int j = 0; j < (int)prev.size(); j++) {
				auto [bw, bh] = prev[j];
				for (int k = 0; k < (int)cur.size(); k++) {
					auto [tw, th] = cur[k];
					if (tw > bw || th > bh) continue;
					int whao = bw - tw + 1;
					int kimmy = bh - th + 1;
					int ways = dp[j] * (whao % MOD) % MOD;
					ways = ways * (kimmy % MOD) % MOD;
					ndp[k] = (ndp[k] + ways) % MOD;
				}
			}
			dp = ndp;
			prev = cur;
		}

		int ans = 0;
		for (int x : dp) {
			ans = (ans + x) % MOD;
		}
		for (int i = 0; i < n; ) {
			int j = i;
			while (j < n && a[i] == a[j]) {
				j++;
			}
			ans = ans * fact[j - i] % MOD;
			i = j;
		}
		cout << ans << '\n';
	}
}