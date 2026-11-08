#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

const double PI = acos(-1.0L);

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int r, s, h; cin >> r >> s >> h;
	// dist from sun, speed in mph, hours in planet's day

	// let's calculate number of days in a year
	double days = ((2 * PI * r) / s) / h;
	// cout << days << '\n';
	// ^ so this is a tropical year
	double goal = abs(days - round(days));
	vector<int> best(3);
	double delta = 100000;
	for (int n1 = 2; n1 <= 1000; n1++) {
		for (int n2 = n1*2; n2 <= 1000; n2 += n1) {
			for (int n3 = n2*2; n3 <= 1000; n3 += n2) {
				double cur = 1.0 / n1 - 1.0 / n2 + 1.0 / n3;
				double test = abs(cur - goal);
				if (test < delta) {
					delta = test;
					best[0] = n1;
					best[1] = n2;
					best[2] = n3;
				}
			}
		}
	}
	cout << best[0] << ' ' << best[1] << ' ' << best[2] << '\n';
}