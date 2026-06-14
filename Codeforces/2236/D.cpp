#include <bits/stdc++.h>
using namespace std;

void solve() {
	int n, k; cin >> n >> k;
	unordered_map<int, int> cnt;
	for (int i = 0; i < n; i++) {
		int x; cin >> x;
		cnt[x]++;
	}

	for (auto &[val, freq] : cnt) {
		if (freq % 2 == 0) {
			cout << "YES\n";
			return;
		}
	}

	vector<int> vals;
	for (auto &[val, freq] : cnt) vals.push_back(val);
	sort(vals.begin(), vals.end());
	for (int i = 0; i + 1 < vals.size(); i++) {
		if (vals[i+1] - vals[i] <= k) {
			cout << "YES\n";
			return;
		}
	}

	cout << "NO\n";
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t;
	while (t--) solve();
}