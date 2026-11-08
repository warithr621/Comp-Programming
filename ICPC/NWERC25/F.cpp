#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	int a[n], b[n];
	int offer = 0, bill = 0;
	for (int i = 0; i < n; i++) {
		cin >> a[i] >> b[i];
		offer += a[i];
		bill += b[i];
	}
	for (int i = 0; i < n; i++) {
		// is bill - (offer - a[i]) <= b[i]?
		if (bill - (offer - a[i]) <= b[i]) {
			cout << i+1 << '\n';
			return 0;
		}
	}
	cout << "impossible\n";
}