#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	int ans = 1;
	while (ans <= 32 && (1LL << ans) <= n) ans <<= 1;
	cout << ans << " bit" << (ans == 1 ? "" : "s") << '\n';
}