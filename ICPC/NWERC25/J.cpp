#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n, k, q; cin >> n >> k >> q;
	// number of people, number of keys, number of trips
	vector<array<int,3>> trips;
	for (int i = 0; i < q; i++) {
		int p, l, r; cin >> p >> l >> r;
		// make sure any return is before any leave
		trips.push_back({i, l, -1});
		trips.push_back({i, r, 1});
	}
	sort(trips.begin(), trips.end(), [](array<int,3> a, array<int,3> b) {
		if (a[1] == b[1]) return a[2] > b[2];
		return a[1] < b[1];
	});
	vector<bool> keys(q, false);
	int peeps = n;
	for (auto [trip, time, type] : trips) {
		if (type == -1) {
			// left
			peeps--;
		} else {
			// return
			if (peeps == 0) {
				keys[trip] = true;
			}
			peeps++;
		}
	}
	int housekeys = k;
	for (auto [trip, time, type] : trips) {
		if (type == -1) {
			// left
			housekeys -= keys[trip];
		} else {
			// return
			housekeys += keys[trip];
		}
		if (housekeys < 0) {
			cout << "impossible\n";
			return 0;
		}
	}
	for (bool b : keys) cout << (b ? '1' : '0');
	cout << '\n';
}