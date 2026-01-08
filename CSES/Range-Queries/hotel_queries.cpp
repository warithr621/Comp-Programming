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
		t[v] = max(t[v*2], t[v*2+1]);
	}
}
 
int mx(int v, int tl, int tr, int l, int r) {
	if (l > r) return 0;
	if (l == tl && r == tr) return t[v];
	int tm = (tl + tr) / 2;
	return max(mx(v*2, tl, tm, l, min(r, tm)), 
		mx(v*2+1, tm+1, tr, max(l, tm+1), r));
}

int get(int pos, int sz) {
	return mx(1, 0, sz-1, pos, pos);
}
 
void update(int v, int tl, int tr, int pos, int changed) {
	if (tl == tr) {
		t[v] = changed;
	} else {
		int tm = (tl + tr) / 2;
		if (pos <= tm) update(v*2, tl, tm, pos, changed);
		else update(v*2+1, tm+1, tr, pos, changed);
		t[v] = max(t[v*2], t[v*2+1]);
	}
}

int first(int v, int tl, int tr, int val) {
	if (t[v] < val) return -1;
	if (tl == tr) return tl;
	int tm = (tl + tr) / 2;
	if (t[v*2] >= val) {
		return first(v*2, tl, tm, val);
	} else {
		return first(v*2+1, tm+1, tr, val);
	}
}
 
signed main() {
	int n, m; cin >> n >> m;
	vector<int> hotels(n);
	for (int &x : hotels) {
		cin >> x;
	}
	build(hotels, 1, 0, n-1);
	while(m--) {
		int r; cin >> r;
		// find the first value in the array that is at least r
		// or return 0 otherwise
		int idx = first(1, 0, n-1, r);
		if (idx == -1) {
			cout << "0 ";
			continue;
		}
		cout << idx+1 << ' ';
		// delete the number of rooms
		update(1, 0, n-1, idx, get(idx, n)-r);
	}
}