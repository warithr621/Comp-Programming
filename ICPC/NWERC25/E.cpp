#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	int n; cin >> n;
	string s; cin >> s;
	cout << fixed << setprecision(8);
	vector<int> f(3);
	for (char c : s) {
		if (c == 'r') ++f[0];
		else if (c == 'g') ++f[1];
		else ++f[2];
	}
	sort(f.begin(), f.end());
	if (!f[0] && !f[1]) {
		cout << "0\n";
		return 0;
	}
	if (!f[0]) {
		// two unique colors
		cout << f[1] * 3 << '\n';
		return 0;
	}

	// it's in your interest to turn f[0] into either f[1] or f[2]
	// then you have like all the options from there
	// so like e.g. you have (2,4,5)
	// you're gonna have either
		// (0,6,5) -> 5*3 moves
		// (0,5,6) -> 5*3 moves
		// (0,4,7) -> 4*3 moves
	// so here it's like 2(3/2) + (1/4)(5*3) + (1/2)(5*3) + (1/4)(4*3) -> 17.25

	double ans = 1.5 * f[0];
	double monke = 1;
	for (int i = 0; i < f[0]; i++) monke /= 2;
	for (int i = 0; i <= f[0]; i++) {
		// current monke works for i, so add to ans and then transition
		int g = f[1] + i, b = f[2] + (f[0] - i);
		ans += monke * (3 * min(g,b));
		monke = monke * (f[0] - i) / (i+1);
	}
	cout << ans << '\n';

}