// https://codeforces.com/contest/1748/problem/B

#include <bits/stdc++.h>
using namespace std;

int works(vector<int> a) {
	int unique = 0;
	for (int i = 0; i < 10; i++) unique += (a[i] > 0);
	for (int i = 0; i < 10; i++) {
		if (a[i] > unique) return 0;
	}
	return 1;
}

void solve() {
	int n; string s;
	cin >> n >> s;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		// left ptr @ 'i'
		vector<int> freq(10, 0);
		int unique = 0, mx = 0;
		for (int j = i; j < n && (++freq[s[j] - '0']) <= 10; ++j) {
			// right ptr @ 'j'
			// cha cha s l i d e
			mx = max(mx, freq[s[j] - '0']);
			if (freq[s[j] - '0'] == 1) ++unique;

			if (unique >= mx) ++ans;
		}
	}

	cout << ans << '\n';
}

int main() {
	int T; cin >> T;
	while(T--) solve();
}