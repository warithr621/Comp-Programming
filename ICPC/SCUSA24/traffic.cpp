#include <bits/stdc++.h>
using namespace std;
#define int long long

int lcm(int a, int b) {
	return a / __gcd(a, b) * b;
}

signed main() {
	int n; cin >> n;
	vector<pair<int, int>> lights;
	for (int i = 0; i < n; ++i) {
		int r, b; cin >> r >> b;
		lights.emplace_back(r, b);
	}
	// only need to brute force up to lcm?
	// how high could that be uhhh
	int l = 1;
	for (auto [r, b] : lights) {
		l = lcm(l, r + b);
	}
	int ans = -1;
	for (int t = 0; t < l; ++t) {
		bool ok = true;
		for (auto [r, b] : lights) {
			if (t % (r + b) < r) {
				ok = false;
				break;
			}
		}
		if (ok) {
			ans = t;
			break;
		}
	}
	cout << ans << '\n';
}

