#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
	int N; cin >> N;
	// we need to be able to store the number of children each node has
	vector<int> children(N, 0);
	for (int i = 1; i < N; i++) {
		int X; cin >> X;
		children[X - 1]++;
	}
	sort(children.rbegin(), children.rend()); // reverse sort
	while (children.back() == 0) children.pop_back(); // remove 0s
	children.push_back(1);

	int ans = 0, sz = children.size();
	for (int i = 0; i < sz; i++) {
		// at minimum, we need sz seconds
		// everything else gets decremented accordingly
		++ans;
		children[i] -= (sz - i);
	}
	sort(children.rbegin(), children.rend());
	while (!children.empty() && children.back() <= 0) children.pop_back();
	
	while (!children.empty()) {
		sz = children.size();
		int last = 0;
		for (int i = 0; i < sz; i++) {
			if (children[i] == children[0]) last = i;
			else break;
		}
		children[last]--;
		for (int i = 0; i < sz; i++) children[i]--;
		++ans;
		while (!children.empty() && children.back() <= 0) children.pop_back();
	}
	cout << ans << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) solve();
}