#include <bits/stdc++.h>
using namespace std;
#define int long long

int n;

void spit_out(__int128 x) {
	string s;
	while (x > 0) {
		s.push_back('0' + (int)(x % 10));
		x /= 10;
	}
	reverse(s.begin(), s.end());
	cout << s << "\n";
}

__int128 solve(vector<int>& a) {
	sort(a.begin(), a.end());
	__int128 tot = 0;
	int pfx = 0;
	for (int i = 0; i < n; i++) {
		tot += (__int128) a[i] * i - pfx;
		pfx += a[i];
	}
	return tot;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> n;
	vector<int> x(n), y(n);
	for (int i = 0; i < n; i++) {
		cin >> x[i] >> y[i];
	}
	__int128 ans = solve(x) + solve(y);
	spit_out(ans);
}