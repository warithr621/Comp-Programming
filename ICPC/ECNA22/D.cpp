#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	string s; cin >> s;
	int n = s.size();
	vector<array<int,4>> v(n+1);
	string dna = "ATGC";
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < 4; j++) {
			v[i][j] = v[i-1][j] + (s[i-1] == dna[j]);
		}
	}
	int q; cin >> q;
	while(q--) {
		int l,r; cin >> l >> r;
		vector<array<int,3>> ans;
		for (int j = 0; j < 4; j++) {
			ans.push_back({v[r][j] - v[l-1][j], dna[j], j}); // freq, letter, index (for tb)
		}
		sort(ans.begin(), ans.end(), [](array<int,3> a, array<int,3> b) {
			if (a[0] != b[0]) return a[0] > b[0];
			return a[2] < b[2];
		});
		for (auto a : ans) cout << char(a[1]);
		cout << '\n';
	}
}