#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	int s[n];
	for (int &x : s) {
		cin >> x;
	}
	int alpha = 0, beta = INT_MAX;
	for (int i = 0; i < n-1; i++) {
		alpha = max(alpha, s[i+1] - s[i]);
	}
	for (int i = 0; i < n-2; i++) {
		beta = min(beta, s[i+2] - s[i]);
	}
	cout << max(alpha, beta) << '\n';
}