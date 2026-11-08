#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n, a, b; cin >> n >> a >> b;
	// a not b, b not a, a and b
	int x = 0, y = 0, z = 0;
	for (int i = 1; i <= n; i++) {
		if (i % a == 0 && i % b == 0) ++z;
		else if (i % a == 0) ++x;
		else if (i % b == 0) ++y;
	}
	cout << x << ' ' << y << ' ' << z << '\n';
}