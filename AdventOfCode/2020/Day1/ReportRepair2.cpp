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
		for (int j = i+1; j < n && a[i] + a[j] < 2020; ++j) {
			int k = lower_bound(a.begin(), a.end(), 2020-a[i]-a[j]) - a.begin();
			while(i == k || j == k) ++k;
			if (k != n && a[i]+a[j]+a[k] == 2020) {
				cout << a[i]*a[j]*a[k] << '\n';
				break;
			}
		}
	}
}