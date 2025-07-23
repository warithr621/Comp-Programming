#include <bits/stdc++.h>
using namespace std;

int main() {
	int x, n; cin >> x >> n;
	vector<int> lights(n);
	for (int &i : lights) cin >> i;
	set<int> pos{0, x};
	for (int l : lights) pos.insert(l);

	vector<int> gaps(n);
	int prev = 0, mx = 0;
	for (int p : pos) {
		mx = max(mx, p - prev);
		prev = p;
	}
	gaps.back() = mx;

	for (int i = n-1; i > 0; i--) {
		pos.erase(lights[i]);
		auto itr = pos.upper_bound(lights[i]);
		int high = *itr, low = *(--itr);
		mx = max(mx, high - low);
		gaps[i-1] = mx;
	}

	for (int v : gaps) cout << v << ' ';
		cout << '\n';
}