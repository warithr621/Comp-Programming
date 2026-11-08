#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int h, w, k, i, t; cin >> h >> w >> k >> i >> t;
	string ans = "KIT" + string(t-1, 'T') + string(k-1, 'K') + string(i-1, 'I');
	for (int x = 0; x < h*w; x += w) {
		cout << ans.substr(x, w) << '\n';
	}

}