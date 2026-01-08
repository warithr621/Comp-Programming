#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MOD = 1'000'000'007;
 
signed main() {
	int n; cin >> n;
	map<int, int> m;
	while (n--) {
		int x; cin >> x;
		m[x]++;
	}
	int ans = 1;
	for (const auto &p : m) ans = ans * (p.second+1) % MOD;
	cout << ans-1 << '\n';
}