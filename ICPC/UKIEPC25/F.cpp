#include <bits/stdc++.h>
using namespace std;
#define int long long

struct DSU {
	vector<int> e;
	DSU(int n) : e(n, -1) {}
	int get(int x) { return e[x] < 0 ? x : e[x] = get(e[x]); }
	bool connected(int a, int b) { return get(a) == get(b); }
	int size(int x) { return -e[get(x)]; }
	bool unite(int a, int b) {
		a = get(a), b = get(b);
		if (a == b) return false;
		if (e[a] > e[b]) swap(a, b);
		e[a] += e[b]; e[b] = a;
		return true;
	}
	void reset() {
		fill(e.begin(), e.end(), -1);
	}
};

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, m; cin >> n >> m;
	vector<int> h(n);
	for (int &x : h) {
		cin >> x;
	}
	vector<pair<int, int>> edges;
	for (int i = 0; i < m; i++) {
		int x,y; cin >> x >> y;
		edges.push_back({x-1, y-1});
	}
	sort(edges.begin(), edges.end(), [&](pair<int,int> a, pair<int,int> b){
		return max(h[a.first], h[a.second]) < max(h[b.first], h[b.second]);
	});

	DSU dsu(n);
	int ans = INT_MAX;
	for (int mh : h) {
		int running = mh;
		// mh is the min height, just append all edges in order
		for (auto p : edges) {
			if (min(h[p.first], h[p.second]) < mh) continue;
			running = max(running, max(h[p.first], h[p.second]));
			// cout << "Connecting " << p.first+1 << " and " << p.second+1 << '\n';
			dsu.unite(p.first, p.second);
			if (dsu.connected(0, 1)) {
				// cout << mh << ' ' << running << '\n';
				ans = min(ans, running - mh);
				break;
			}
		}
		dsu.reset();
	}
	cout << ans << '\n';
}