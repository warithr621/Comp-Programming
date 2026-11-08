#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n; cin >> n;
	vector<string> actions(n);
	vector<vector<int>> info(n, vector<int>(3));
	for (int i = 0; i < n; i++) {
		cin >> actions[i] >> info[i][0] >> info[i][1] >> info[i][2];
	}
	int k; cin >> k;
	// time cheese glory

	pair<int, int> ans = {0,0};
	for (int i = 0; i < n; i++) {
		if (info[i][0] > k) continue;
		ans.first += info[i][1] * (actions[i] == "CAUGHT" ? 1 : -1);
		ans.second += info[i][2] * (actions[i] == "CAUGHT" ? 1 : -1);
	}
	cout << ans.first << ' ' << ans.second << '\n';
}