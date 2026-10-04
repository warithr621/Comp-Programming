#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int t; cin >> t;
	while (t--) {
		int n; cin >> n;
		vector<bool> used(4);
		while(n--) {
			int x; cin >> x;
			used[(--x)/10] = true;
		}
		cout << accumulate(used.begin(), used.end(), 0ll) << '\n';
	}
}