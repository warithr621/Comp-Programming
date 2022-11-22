// AoC 2020 D1

#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main() {
	freopen("input.txt", "r", stdin);
	
	vector<int> a;
	int n;
	while(cin >> n) a.push_back(n);
	sort(a.begin(), a.end());

	for (int i = 0; i < (int) a.size(); i++) {
		auto itr = lower_bound(a.begin(), a.end(), 2020 - a[i]);
		if (*itr + a[i] == 2020 and itr != a.begin() + i) {
			cout << a[i] * *itr << '\n';
			break;
		}
	}
}