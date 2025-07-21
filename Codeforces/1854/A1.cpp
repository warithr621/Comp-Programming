// https://codeforces.com/contest/1854/problem/A1

#include <bits/stdc++.h>
using namespace std;

void solve() {
	int n; cin >> n;
	vector<int> a(n);
	for (int &i : a) cin >> i;
	bool pos = true, neg = true; // all + or all -
	for (int x : a) {
		if (x > 0) neg = false;
		if (x < 0) pos = false;
	}
	if (pos and neg) {
		// all zeros lol
		cout << "0\n";
		return;
	}
	if (pos) {
		// trivial by prefix sums
		cout << n-1 << '\n';
		for (int i = 2; i <= n; i++) {
			cout << i << ' ' << i-1 << '\n';
		}
		return;
	}
	if (neg) {
		// trivial by suffix sums
		cout << n-1 << '\n';
		for (int i = n; i >= 2; i--) {
			cout << i-1 << ' ' << i << '\n';
		}
		return;
	}
	// what if we have a mix?
	int idx = 0;
	for (int i = 0; i < n; i++) {
		if (a[i] > a[idx]) idx = i;
	}
	vector<pair<int, int>> ops;
	for (int i = 0; i < 5; i++) {
		ops.push_back({idx+1, idx+1});
	}
	if (n >= 2) {
		ops.push_back({2, idx+1});
		ops.push_back({2, idx+1});
	}
	for (int i = 3; i <= n; i++) {
		ops.push_back({i, i-1});
		ops.push_back({i, i-1});
	}
	cout << ops.size() << '\n';
	for (auto p : ops) {
		cout << p.first << ' ' << p.second << '\n';
	}
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) solve();
}