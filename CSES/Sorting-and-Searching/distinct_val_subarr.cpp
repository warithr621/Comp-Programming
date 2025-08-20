#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n; cin >> n;
	int a[n];
	for (int &x : a) {
		cin >> x;
	}
	int ans = 0;
	map<int, int> f;
	int left = 0;
	for (int right = 0; right < n; right++) {
		f[a[right]]++;
		while (f[a[right]] > 1) {
			f[a[left]]--;
			left++;
		}
		ans += right - left + 1;
	}
	cout << ans << '\n';
}