#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int r, c; cin >> r >> c;
	bool less = true;
	for (int i = 0; i < r; i++) {
		string s; cin >> s;
		int dots = c - (int) s.size();
		int ldots = dots/2, rdots = dots - ldots;
		if (!less) swap(ldots, rdots);
		if (dots % 2) less = !less;
		for (int j = 0; j < ldots; j++) cout << '.';
		cout << s;
		for (int j = 0; j < rdots; j++) cout << '.';
		cout << '\n';
	}
}

