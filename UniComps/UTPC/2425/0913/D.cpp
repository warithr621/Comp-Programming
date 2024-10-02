#include <bits/stdc++.h>
using namespace std;
#define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;

void solve() {
	int n, m; cin >> n >> m;
	int a[n];
	for (int &i : a) cin >> i;
	vector<int> pfx(n+1);
	pfx[0] = 0;
	for (int i = 1; i <= n; i++) {
		pfx[i] = pfx[i-1] + a[i-1];
	}
	while (m --> 0) {
		int look; cin >> look;
		// find lower bound???
		if (look == 0) cout << "0\n"; // fuck whoever made this edgecase
		else if (look > pfx[n]) cout << "-1\n";
		else {
			auto argh = lower_bound(next(pfx.begin(), 1), pfx.end(), look);
			cout << distance(pfx.begin(), argh) << '\n';
		}
	}
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	// cin >> T;
	while (T --> 0) solve();
}
