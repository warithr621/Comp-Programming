#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n,m; cin >> n >> m;
	vector<int> w(n);
	for (int &x : w) {
		cin >> x;
	}
	sort(w.begin(), w.end());
	// i think just pair big and small no?
	int ans = 0, L = 0, R = n-1;
	while (L <= R) {
		if (w[L] + w[R] <= m) L++;
		ans++;
		R--;
	}
	cout << ans << '\n';

}