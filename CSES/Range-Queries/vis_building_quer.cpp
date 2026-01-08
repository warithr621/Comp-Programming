#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MAXN = 100'005;

vector<int> tree[4 * MAXN];

void build(vector<int> &vec, int v, int l, int r) {
	if (l == r) {
		tree[v] = {vec[l]};
		return;
	}
	int m = (l + r) >> 1;
	build(vec, v << 1, l, m);
	build(vec, v << 1 | 1, m+1, r);
	// now for the hard part
	const auto &A = tree[v << 1];
	const auto &B = tree[v << 1 | 1];
	tree[v] = A;
	int maxA = A.back();
	auto it = std::upper_bound(B.begin(), B.end(), maxA);
	tree[v].insert(tree[v].end(), it, B.end());
}

int query(int v, int l, int r, int ql, int qr, int &last) {
	if (qr < l || r < ql) return 0;
	if (ql <= l && r <= qr) {
		auto &vec = tree[v];
		auto it = upper_bound(vec.begin(), vec.end(), last);
		if (it == vec.end()) return 0;
		last = vec.back();
		return vec.end() - it;
	}

	int m = (l + r) >> 1;
	int ans = 0;
	ans += query(v << 1, l, m, ql, qr, last);
	ans += query(v << 1 | 1, m + 1, r, ql, qr, last);
	return ans;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int n, q; cin >> n >> q;
	vector<int> h(n);
	for (int &x : h) {
		cin >> x;
	}
	build(h, 1, 0, n-1);
	while(q--) {
		int a,b; cin >> a >> b;
		--a; --b;
		int prev_mx = -1e10;
		cout << query(1, 0, n-1, a, b, prev_mx) << '\n';
	}
}