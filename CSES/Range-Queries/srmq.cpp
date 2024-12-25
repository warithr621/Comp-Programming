// Static Range Minimum Queries

#include <bits/stdc++.h>
using namespace std;
#define int long long
const int DEFAULT = 1'000'000'007;

signed main() {
	int n, q; cin >> n >> q;
	int x[n+1];
	for (int i = 1; i <= n; i++) {
		cin >> x[i];
	}
	// use sqrt decomp
	int s = (int) sqrt(n);
	vector<int> chunks;
	vector<pair<int,int>> ranges;
	int left = 1;
	int cur = DEFAULT;
	for (int i = 1; i <= n; i++) {
		cur = min(cur, x[i]);
		if (i % s == 0) {
			ranges.push_back({left, i});
			left = i + 1;
			chunks.push_back(cur);
			cur = DEFAULT;
		}
	}
	if (cur != DEFAULT) {
		ranges.push_back({left, n});
		chunks.push_back(cur);
	}

	// now do the actual queries
	while (q--) {
		int a,b; cin >> a >> b;
		// find the ranges containing 'a' and 'b', then go in between them;
		int il = 0, ir = 0;
		for (int i = 0; i < ranges.size(); i++) {
			auto cp = ranges[i];
			if (cp.first <= a and a <= cp.second) il = i;
			if (cp.first <= b and b <= cp.second) ir = i;
		}
		int ans = DEFAULT;
		if (il == ir) {
			for (int i = a; i <= b; i++) ans = min(ans, x[i]);
		} else {
			for (int i = a; i <= ranges[il].second; i++) ans = min(ans, x[i]);
			for (int i = b; i >= ranges[ir].first; i--) ans = min(ans, x[i]);
			for (int i = il + 1; i <= ir - 1; i++) ans = min(ans, chunks[i]);
		}
		cout << ans << '\n';
	}
}