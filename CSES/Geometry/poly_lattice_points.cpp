#include <bits/stdc++.h>
using namespace std;
#define int long long

// pick's states area = I + B/2 - 1
// so abs(sum determinants) = 2I + B - 2

int area(vector<pair<int,int>> &points) {
	// shoelace, but I don't divide by 2 at the end
	int sigma = 0;
	for (int i = 1; i < points.size(); i++) {
		sigma += points[i-1].first * points[i].second - points[i-1].second * points[i].first;
	}
	return abs(sigma);
}

int boundary(vector<pair<int,int>> &points) {
	// calc no. of boundary points
	int cnt = points.size() - 1; // vertices
	for (int i = 1; i < points.size(); i++) {
		int dx = abs(points[i].first - points[i-1].first);
		int dy = abs(points[i].second - points[i-1].second);
		if (dx == 0) cnt += dy-1;
		else if (dy == 0) cnt += dx-1;
		else {
			int g = __gcd(dx, dy);
			cnt += g-1;
		}
	}
	return cnt;
}

signed main() {
	int n; cin >> n;
	vector<pair<int,int>> points(n+1);
	for (int i = 0; i < n; i++) {
		int x,y; cin >> x >> y;
		points[i] = {x,y};
		if (i == 0) points[n] = {x,y};
	}
	int A = area(points), B = boundary(points);
	cout << ((A-B)>>1) + 1 << ' ' << B << '\n';
}