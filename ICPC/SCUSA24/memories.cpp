#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n, k; cin >> n >> k;
	vector<int> p(n);
	for (int &x : p) {
		cin >> x;
	}
	int L = 1, R = 1e18;
	while (L < R) {
		int mid = (L + R) / 2;
		int cnt = 0;
		for (int x : p) {
			cnt += (x + mid - 1) / mid;
			if (cnt > k) break;
		}
		if (cnt <= k) {
			R = mid;
		} else {
			L = mid + 1;
		}
		// cout << L << ' ' << R << '\n';
	}
	cout << L << '\n';
}

