#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int t; cin >> t;
	while (t--) {
		int n, m; cin >> n >> m;
		bool works = true;
		int cnt = 0;
		while(m--) {
			int a,b; cin >> a>> b;
			if (a > b) works = false;
			if (a + 1 == b) cnt++;
		}
		if (!works) cout << "-1\n";
		else cout << (n-1) - cnt << '\n';
	}
	return 0;
}