// CSES Line Segment Intersection

#include <bits/stdc++.h>
using namespace std;
#define int long long

pair<int, int> vec(pair<int, int> a, pair<int, int> b) {
	return {b.first - a.first, b.second - a.second};
}

int cross(pair<int, int> a, pair<int, int> b) {
	return a.first * b.second - b.first * a.second;
}

int sign(int x) {
	return (x > 0 ? 1 : (x < 0 ? -1 : 0));
}

bool between(pair<int, int> L, pair<int, int> R, pair<int, int> M) {
	vector< pair<int, int> > v = {L, M, R};
	sort(v.begin(), v.end(), [](const pair<int, int> &a, const pair<int, int> &b) {
		return (a.first == b.first ? (a.second < b.second) : (a.first < b.first));
	});
	return v[1] == M;
}

void solve() {
	pair<int, int> points[4];
	for (int i = 0; i < 4; i++) {
		int x,y; cin >> x >> y;
		points[i] = {x, y};
	}

	int c1 = cross(vec(points[0], points[1]), vec(points[0], points[2]));
	int c2 = cross(vec(points[0], points[1]), vec(points[0], points[3]));
	int c3 = cross(vec(points[2], points[3]), vec(points[2], points[0]));
	int c4 = cross(vec(points[2], points[3]), vec(points[2], points[1]));

	string ans = "NO";
	if (c1 == 0 and between(points[0], points[1], points[2])) {
		ans = "YES";
	}
	if (c2 == 0 and between(points[0], points[1], points[3])) {
		ans = "YES";
	}
	if (c3 == 0 and between(points[2], points[3], points[0])) {
		ans = "YES";
	}
	if (c4 == 0 and between(points[2], points[3], points[1])) {
		ans = "YES";
	}
	if (sign(c1) != sign(c2) && sign(c3) != sign(c4)) {
		ans = "YES";
	}
	cout << ans << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) solve();
}