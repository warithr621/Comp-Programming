#include <bits/stdc++.h>
using namespace std;
#define int long long

bool corner(int x, int y) {
	return (x == 0 || x == 2024) && (y == 0 || y == 2024);
}

signed main() {
	int x1, y1, x2, y2;
	cin >> x1 >> y1 >> x2 >> y2;
	int ans = corner(x1, y1) + corner(x2, y2);
	cout << 2 - ans << '\n';
}