#include <bits/stdc++.h>
using namespace std;

signed main() {
	int n, q; cin >> n >> q;
	vector<int> awa(n);
	vector<int> pos(n+1);
	for (int i = 0; i < n; i++) {
		cin >> awa[i];
		pos[awa[i]] = i;
	}
	auto bad = [&](int i) {
		return pos[i] < pos[i-1];
	};
	int ans = 1;
	for (int i = 2; i <= n; i++) ans += bad(i);

	while (q--) {
		int a, b; cin >> a >> b;
		int x = awa[--a], y = awa[--b];
		set<int> affected;
		for (int v : {x, x+1, y, y+1}) {
			if (v >= 2 && v <= n) affected.insert(v);
		}
		for (int v : affected) ans -= bad(v);
		pos[x] = b; pos[y] = a;
		awa[b] = x; awa[a] = y;
		for (int v : affected) ans += bad(v);
		cout << ans << '\n';
	}
}