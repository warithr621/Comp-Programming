#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	int m; cin >> m;
	int c[m];
	for (int &x : c) {
		cin >> x;
	}
	int n, e; cin >> n >> e;
	vector<int> bills(n);
	vector<int> belt(n+1);
	int idx = 0;
	vector<pair<int, int>> events;
	for (int i = 0; i < e; i++) {
		int t,p; cin >> t >> p;
		events.push_back({t, p});
	}
	int tracker = 0;
	for (int skibidi = 0; skibidi <= 10000 && tracker != e; skibidi++) {
		// place plates + have people take plates, then cycle
		if (belt[0] == 0) {
			belt[0] = c[idx];
			idx = (idx + 1) % m;
		}
		while (tracker < e && events[tracker].first == skibidi) {
			int person = events[tracker].second;
			bills[person-1] += belt[person];
			belt[person] = 0;
			tracker++;
		}
		rotate(belt.begin(), belt.end()-1, belt.end());
		// for (int x : belt) cout << x << ' ';
		// cout << '\n';
	}
	for (int x : bills) cout << x << '\n';
}