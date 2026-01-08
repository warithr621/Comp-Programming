#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MOD = 1'000'000'007;

struct Fenwick {
	int n;
	vector<int> bit;

	Fenwick(int n) : n(n), bit(n + 1, 0) {}

	void add(int i, int v) {
		for (; i <= n; i += i & -i) {
			bit[i] = (bit[i] + v) % MOD;
		}
	}

	int sum(int i) {
		int s = 0;
		for (; i > 0; i -= i & -i) {
			s = (s + bit[i]) % MOD;
		}
		return s;
	}
};

signed main() {
	int n; cin >> n;
	vector<int> a(n);
	for (int &x : a) {
		cin >> x;
	}

	vector<int> vals = a;
	sort(vals.begin(), vals.end());
	vals.erase(unique(vals.begin(), vals.end()), vals.end());
	auto get_id = [&](int x) {
		return (int)(lower_bound(vals.begin(), vals.end(), x) - vals.begin()) + 1;
	};

	Fenwick fw(vals.size());
	int ans = 0;
	for (int i = 0; i < n; i++) {
		int v = get_id(a[i]);
		int cur = 1 + fw.sum(v - 1);
		fw.add(v, cur % MOD);
		ans = (ans + cur) % MOD;
	}
	cout << ans << '\n';
}