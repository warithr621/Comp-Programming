#include <bits/stdc++.h>
using namespace std;

struct Fenwick {
	int n;
	vector<int> bit;
	Fenwick(int n) : n(n), bit(n + 1, 0) {}
	void update(int pos, int val) {
		for (; pos <= n; pos += pos & (-pos)) bit[pos] += val;
	}
	int pfx(int pos) {
		int s = 0;
		for (; pos > 0; pos -= pos & (-pos)) s += bit[pos];
		return s;
	}
	int query(int l, int r) {
		if (l > r) return 0;
		return pfx(r) - pfx(l - 1);
	}
};

int main() {
	cin.tie(0)->sync_with_stdio(0);

	int n, q;
	cin >> n >> q;
	vector<int> x(n);
	for (int &v : x) cin >> v;

	// coord compress, since we only have at most 2e5 unique values
	vector<int> comp = x;
	sort(comp.begin(), comp.end());
	comp.erase(unique(comp.begin(), comp.end()), comp.end());
	int m = comp.size();

	// list of (sign, a rank, b rank, query number)
	// we gonna process these offline
	vector<vector<array<int,4>>> events(n + 1);
	vector<int> ans(q, 0);
	for (int qi = 0; qi < q; qi++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		int left = lower_bound(comp.begin(), comp.end(), c) - comp.begin() + 1;
		int right = upper_bound(comp.begin(), comp.end(), d) - comp.begin();
		events[b].push_back({+1, left, right, qi});
		if (a-1 >= 1) events[a-1].push_back({-1, left, right, qi});
		// if a-1 = 0 this is just 0 lol, no point in making some new calculation
	}

	Fenwick fw(m);
	for (int i = 1; i <= n; i++) {
		int rank = lower_bound(comp.begin(), comp.end(), x[i - 1]) - comp.begin() + 1;
		fw.update(rank, 1); // an occurrence of the number
		for (auto &e : events[i]) {
			int sign = e[0], left = e[1], right = e[2], qi = e[3];
			ans[qi] += sign * fw.query(left, right);
		}
	}
	for (int v : ans) cout << v << '\n';

	// if F(t,c,d) returns the number of elements c <= x <= d among the first t elements
	// we want F(b,c,d) - F(a-1,c,d)
	// fw.query(c,d) does the exact same thing
	// our for loop just calculates F(t,c,d) for t={1,2,...} and updates all the answers accordingly
	// since events[i] contains only the elements with i, we process everything in order without any weird overcounting yada
}