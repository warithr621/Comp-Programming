#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n; cin >> n;
	int a[n];
	for (int &x : a) {
		cin >> x;
	}
	int ans = 0;
	for (int i = 1; i < n-1; i++) {
		if (a[i] - a[i-1] > a[i+1] - a[i]) ans++;
	}
	cout << ans << '\n';
}