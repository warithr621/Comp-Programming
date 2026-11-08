#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n, q; cin >> n >> q;
	string s; cin >> s;
	// ok wait the fact we query and this problem still solved a lot
	// probably implies the order doesnt matter?

	// suppose we have A 4s and B 8s
	// and we're tryna get to (x,y)
	// note that an 8 is just two 4s
		// (ok no shit but like in context of problem too)
	// so if a + 2b >= x + y we should be able to reach it?
	vector<int> fours(n+1);
	for (int i = 1; i <= n; i++) {
		fours[i] = fours[i-1] + (s[i-1] == '4');
	}
	while(q--) {
		int l, r, x, y; cin >> l >> r >> x >> y;
		x = abs(x); y = abs(y);
		int a = fours[r] - fours[l-1];
		int b = (r-l+1) - a;
		// cout << a << ' ' << b << ' ';
		if (a + 2*b >= x + y && a + b >= max(x,y)) {
			cout << "YES\n";
		} else {
			cout << "NO\n";
		}
	}
}