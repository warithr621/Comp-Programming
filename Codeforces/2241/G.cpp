%:include <bits/stdc++.h>
using namespace std;
%:define int long long

ostream& operator<<(ostream& os, __int128 x) {
	if (x == 0) return os << "0";
	string s;
	bool sign = x < 0;
	if (sign) x = -x;
	while (x > 0) {
		s += (char)('0' + (x % 10));
		x /= 10;
	}
	if (sign) s += '-';
	reverse(s.begin(), s.end());
	return os << s;
}

void solve() {
	int n; cin >> n;
	vector<int> a(n);
	for (int &x : a) {
		cin >> x;
	}
	map<int, int> lefts;
	__int128 ans = 0;
	for (int i = 0; i < n; i++) {
		__int128 contribution = 0;
		for (auto it = lefts.begin(); it != lefts.end();) {
			int v = it->first, cnt = it->second;
			int mod = a[i] % v;
			int d = min(mod, v - mod);
			if (d > 0) {
				contribution += (__int128) d * (n - i) * cnt;
				it = lefts.erase(it);
			} else {
				++it;
			}
		}
		ans += contribution;
		lefts[a[i]]++;
	}
	cout << ans << '\n';
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
}