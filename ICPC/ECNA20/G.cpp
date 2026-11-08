#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	cout << fixed << setprecision(8);

	int n,m; cin >> n >> m;
	vector<int> ranks(n);
	for (int i = 0; i < n; i++) {
		ranks[i] = i+1;
	}
	while(m--) {
		string s, t; cin >> s >> t; // s/x beat t/y
		int x = stoi(s.substr(1)), y = stoi(t.substr(1));
		if (find(ranks.begin(), ranks.end(), x) < find(ranks.begin(), ranks.end(), y)) continue; // who cares, better beat worse
		// otherwise, we now need to insert y right after x
		ranks.erase(find(ranks.begin(), ranks.end(), y));
		ranks.insert(find(ranks.begin(), ranks.end(), x)+1, y);
		// for (int x : ranks) cout << 'T' << x << ' ';
		// cout << '\n';
	}
	for (int x : ranks) cout << 'T' << x << ' ';
}