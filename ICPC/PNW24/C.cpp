#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	int cur = 0, mx = 0;
	for (int i = 0; i < n; i++) {
		int a,b; cin >> a >> b;
		cur = cur - a + b;
		mx = max(cur, mx);
	}
	cout << mx << '\n';
}