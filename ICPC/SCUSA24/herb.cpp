#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int g, r; cin >> g >> r;
	int init = min(g,r);
	int ans = 10 * init;
	g -= init; r -= init;
	ans += (g/3) * 10 + (g%3) + (g%3==2 ? 1 : 0);
	cout << ans << '\n';
}