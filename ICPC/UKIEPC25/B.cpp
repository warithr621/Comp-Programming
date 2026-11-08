#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	vector<array<int,4>> blocks;
	for (int i = 0; i < n; i++) {
		int x, y, w, h; cin >> x >> y >> w >> h;
		blocks.push_back({x, y, w, h});
	}
	pair<int, int> mnp = {LLONG_MAX, LLONG_MAX}, mxp = {LLONG_MIN, LLONG_MIN};
	for (auto [x, y, w, h] : blocks) {
		mnp.first = min(mnp.first, x);
		mnp.second = min(mnp.second, y);
		mxp.first = max(mxp.first, x + w);
		mxp.second = max(mxp.second, y + h);
	}
	int goal = (mxp.first - mnp.first) * (mxp.second - mnp.second);
	for (auto [x, y, w, h] : blocks) {
		goal -= w * h;
	}
	if (goal != 0) {
		// either blocks spaced out or overlap
		cout << "no\n";
		return 0;
	}

	// ok shii apparently i needa do more math
	// do i just do vertical sweepline?? bro :sob:
	vector<array<int,4>> ranges;
	for (auto [x, y, w, h] : blocks) {
		ranges.push_back({x, x+w, y, 1}); // rect starts
		ranges.push_back({x, x+w, y+h, -1}); // rect ends
		// wanna do any removals before any adds
	}
	sort(ranges.begin(), ranges.end(), [](array<int,4> a, array<int,4> b) {
		if (a[2] != b[2]) return a[2] < b[2];
		return a[3] < b[3];
	});
	multiset<pair<int,int>> active;
	for (auto arr : ranges) {
		if (arr[3] == -1) {
			// just remove lol
			// cout << "Removing " << arr[0] << ' ' << arr[1] << " at y = " << arr[2] << '\n';
			active.erase(active.find({arr[0], arr[1]}));
		} else {
			// add the thing, then see if it overlaps w neighbors
			// cout << "Adding " << arr[0] << ' ' << arr[1] << " at y = " << arr[2] << '\n';
			active.insert({arr[0], arr[1]});
			auto it = active.find({arr[0], arr[1]});
			if (it != active.begin()) {
				if (prev(it)->second > arr[0]) {
					cout << "no\n";
					return 0;
				}
			}
			if (next(it) != active.end()) {
				if (arr[1] > next(it)->first) {
					cout << "no\n";
					return 0;
				}
			}
		}
	}
	cout << "yes\n";
}