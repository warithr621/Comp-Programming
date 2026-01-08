#include <bits/stdc++.h>
using namespace std;
#define int long long

struct Point {
	int x, y;
	bool operator==(const Point& p) const {
		return x == p.x && y == p.y;
	}
};

bool contains(Point &start, Point &end, Point &test) {
	long long cross =
		(end.x - start.x) * (test.y - start.y) -
		(end.y - start.y) * (test.x - start.x);
	
	if (cross != 0) return false;
	return min(start.x, end.x) <= test.x && test.x <= max(start.x, end.x) &&
		   min(start.y, end.y) <= test.y && test.y <= max(start.y, end.y);
}

bool intersects(Point &start, Point &end, Point &test) {
	if ((start.y > test.y) == (end.y > test.y)) return false;

	long double x_intersect =
		start.x + (long double)(test.y - start.y) *
		(end.x - start.x) / (long double)(end.y - start.y);
	return x_intersect > test.x;
}

signed main() {
	int n, m; cin >> n >> m;
	vector<Point> p(n + 1);
	for (int i = 0; i < n; i++) {
		cin >> p[i].x >> p[i].y;
		if (i == 0) p[n] = p[i];
	}

	while (m--) {
		int a, b; cin >> a >> b;
		Point test = {a, b};
		bool boundary = false;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			boundary |= contains(p[i-1], p[i], test);
			cnt += intersects(p[i-1], p[i], test);
		}

		if (boundary) cout << "BOUNDARY\n";
		else cout << ((cnt & 1) ? "INSIDE" : "OUTSIDE") << '\n';
	}
}