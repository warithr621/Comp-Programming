#include <bits/stdc++.h>
using namespace std;
#define int long long

int gen(int start, int len) {
	int x = 0;
	for (int i = 0; i < len; i++) {
		x = x * 10 + start;
		start++;
	}
	return x;
}

signed main() {
	vector<int> skull;
	for (int len = 1; len <= 9; len++) {
		for (int start = 1; start + len - 1 <= 9; start++) {
			skull.push_back(gen(start, len));
		}
	}
	int t; cin >> t;
	while (t--) {
		int n; cin >> n;
		auto it = lower_bound(skull.begin(), skull.end(), n);
		cout << *it << '\n';
	}
}