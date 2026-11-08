#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n; cin >> n;
	vector<int> f(1001);
	while(n--) {
		int x; cin >> x;
		f[x]++;
	}
	int ans = 0;
	for (int i = 0; i < 1001; i++) {
		if (f[i] > i) ans += f[i] - i;
		else if (f[i] < i) ans += f[i];
	}
	cout << ans << '\n';
}