#include <bits/stdc++.h>
using namespace std;
#define int long long

const long double pi = acos(-1.0L); 

long double f(int m, int t, int n) {
	long double l = 1.0L * (t - m * n) / n;
	return (l*l/4) * 1.0L/tan(pi/n) * n;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int c; cin >> c;
	while (c--) { // wow new language
		int m, t; cin >> m >> t;
		if (t - 3 * m <= 0) {
			cout << "0\n";
			continue;
		}
		// ternary search?? :o
		int L = 3, R = (t-1)/m;
		while (R - L > 1) {
			// cout << L << ' ' << R << '\n';
			int mid = (L + R) / 2;
			if (f(m, t, mid) > f(m, t, mid+1)) {
				R = mid;
			} else {
				L = mid;
			}
		}
		cout << fixed << setprecision(8) << max(f(m, t, L), f(m, t, R)) << "\n";
	}
}