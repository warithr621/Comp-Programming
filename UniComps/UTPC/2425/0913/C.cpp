#include <bits/stdc++.h>
using namespace std;
#define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;

void solve() {
	int n; cin >> n;
	string s; cin >> s;
	char cur = s[0];
	int len = 0;
	vi a, b;
	int v = 0;
	for (int i = 0; i < n; i++) {
		if (s[i] == cur) ++len;
		else {
			(v == 0 ? a : b).push_back(len);
			cur = s[i];
			len = 1;
			v ^= 1;
		}
	}
	(v == 0 ? a : b).push_back(len);
	cout << min((int) a.size(), (int) b.size()) << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	// cin >> T;
	while (T --> 0) solve();
}