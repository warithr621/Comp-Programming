// 2016 Dec Silver P1

#include <iostream>
#include <vector>
#include <algorithm>
#define int long long
using namespace std;

int32_t main() {
	freopen("haybales.in", "r", stdin);
	freopen("haybales.out", "w", stdout);

	int n,q; cin >> n >> q;
	vector<int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];
	sort(a.begin(), a.end());

	while(q--) {
		int l,r; cin >> l >> r;
		
		int lidx = upper_bound(a.begin(), a.end(), --l) - a.begin();
		int ridx = upper_bound(a.begin(), a.end(), r) - a.begin();

		cout << ridx - lidx << '\n';
	}
}