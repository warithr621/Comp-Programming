// 2015 Dec Silver P2

#include <iostream>
#include <vector>
using namespace std;

vector<int> remove(vector<int> a, int idx) {
	a.erase(a.begin() + idx);
	return a;
}

int32_t main() {
	freopen("highcard.in", "r", stdin);
	freopen("highcard.out", "w", stdout);

	int n; cin >> n;
	vector<bool> e(2*n+1, false);
	//e[i] is true if elsie has it
	for (int i = 0; i < n; i++) {
		int x; cin >> x; e[x] = true;
	}

	vector<int> bessie, elsie;
	for (int i = 1; i <= 2*n; i++) {
		if (e[i]) elsie.push_back(i);
		else bessie.push_back(i);
	}
	//note bessie and elsie are in order

	int ans = 0, bidx = 0, eidx = 0;
	while(bidx < n && eidx < n) {
		if (bessie[bidx] > elsie[eidx]) {
			//use this immediately and win a point
			++ans; ++bidx; ++eidx;
		} else {
			//we can't ever use this card to win
			++bidx;
		}
	}
	cout << ans << '\n';
}
