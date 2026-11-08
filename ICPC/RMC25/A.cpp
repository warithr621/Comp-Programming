#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	vector<string> dirs = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
	string cur, dest; cin >> cur >> dest;
	if (cur == dest) {
		cout << "Keep going straight\n";
		return 0;
	}
	int i = 0, j = 0;
	for (int v = 0; v < 8; v++) {
		if (dirs[v] == cur) i = v;
		if (dirs[v] == dest) j = v;
	}
	int angle = abs(i-j);
	angle = 45 * min(angle, 8-angle);
	if (angle == 180) {
		cout << "U-turn\n";
		return 0;
	} else {
		if ((j > i && j-i<4) || (j < i && i-j>4)) {
			cout << "Turn " << angle << " degrees starboard\n";
		} else {
			cout << "Turn " << angle << " degrees port\n";
		}
	}
}