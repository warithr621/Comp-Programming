#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	string s; cin >> s;
	int ans = (s[0] == '0' ? 10 : s[0] - '0');
	int idx = (s[0] == '0' ? 2 : 1);
	for (int i = 1; i < n; i++) {
		// maybe ans has it lol
		while (true) {
			// check the current "ans", then keep incrementing if needed
			// you should only need to increment up to 10 times per digit so this should be fine?
			string test = to_string(ans);
			while (idx < test.size() && test[idx] != s[i]) ++idx;
			if (idx == test.size()) {
				ans++;
				idx = 0;
			} else {
				idx++;
				break;
			}
		}
	}
	cout << ans << '\n';
}