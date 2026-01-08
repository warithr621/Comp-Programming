#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MAXN = (int) (2e5) + 1;
int t[4 * MAXN];
 
void build(const vector<int> &vec, int v, int tl, int tr) {
	if (tl == tr) {
		t[v] = vec[tl];
	} else {
		int tm = (tl + tr) / 2;
		build(vec, v*2, tl, tm);
		build(vec, v*2+1, tm+1, tr);
		t[v] = t[v*2] + t[v*2+1];
	}
}
 
int sum(int v, int tl, int tr, int l, int r) {
	if (l > r) return 0;
	if (l == tl && r == tr) return t[v];
	int tm = (tl + tr) / 2;
	return sum(v*2, tl, tm, l, min(r, tm)) + 
		sum(v*2+1, tm+1, tr, max(l, tm+1), r);
}

int get(int pos, int sz) {
	return sum(1, 0, sz-1, pos, pos);
}
 
void update(int v, int tl, int tr, int pos, int changed) {
	if (tl == tr) {
		t[v] = changed;
	} else {
		int tm = (tl + tr) / 2;
		if (pos <= tm) update(v*2, tl, tm, pos, changed);
		else update(v*2+1, tm+1, tr, pos, changed);
		t[v] = t[v*2] + t[v*2+1];
	}
}
 
signed main() {
	int n, q; cin >> n >> q;
	vector<int> orig(n);
	for (int &x : orig) {
		cin >> x;
	}
	while (q--) {
		int type; cin >> type;
		if (type == 1) {
			int a,b,u; cin >> a >> b >> u;
			update(1, 0, n, a, get(a, n+1)+u);
			if (b + 1 <= n) {
				update(1, 0, n, b+1, get(b+1, n+1)-u);
			}
		} else {
			int k; cin >> k;
			cout << sum(1, 0, n, 0, k) + orig[k-1] << '\n';
		}
	}
}