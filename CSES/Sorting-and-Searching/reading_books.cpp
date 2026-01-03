#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n, x, sum = 0, mx = 0; cin >> n;
	for (int i = 0; i < n and (cin >> x); i++) {
		sum += x;
		mx = max(mx, x);
	}
	cout << (mx > (sum>>1) ? (mx<<1) : (sum)) << '\n';
}