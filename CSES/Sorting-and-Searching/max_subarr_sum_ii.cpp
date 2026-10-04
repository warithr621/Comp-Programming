#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n, a, b; cin >> n >> a >> b;
	vector<int> nums(n+1, 0);
	for (int i = 1; i <= n; i++) {
		cin >> nums[i];
	}
	for (int i = 1; i <= n; i++) {
		nums[i] += nums[i-1];
	}
	int ans = LLONG_MIN;
	multiset<int> ms;
	for (int i = 0; i <= n; i++) {
		if (i >= a) {
			ms.insert(nums[i-a]);
		}
		if (i > b) {
			ms.erase(ms.find(nums[i-b-1]));
		}
		if (!ms.empty()) {
			ans = max(ans, nums[i] - *ms.begin());
		}
	}
	cout << ans << '\n';
}