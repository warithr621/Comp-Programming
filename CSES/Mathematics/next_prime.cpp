#include <bits/stdc++.h>
using namespace std;
#define int long long

bool prime(int x) {
	if (x <= 1) return false;
	if (x <= 3) return true;
	if (x % 2 == 0 || x % 3 == 0) return false;
	for (int i = 5; i * i <= x; i += 6) {
		if (x % i == 0 || x % (i + 2) == 0) return false;
	}
	return true;
}

signed main() {
	int t; cin >> t;
	while (t --> 0) {
		int n; cin >> n;
		n++;
		while (!prime(n)) ++n;
		cout << n << '\n';
	}
}