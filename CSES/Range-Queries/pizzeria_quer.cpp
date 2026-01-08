#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MAXN = 200'005;
static const int INF = 1e10;

// note that the total price is either
// p_a + a - b, if a >= b
// p_a - a + b, if a <= b

// maybe we make two segtrees again
int pos[4*MAXN], neg[4*MAXN]; // min trees

void build(vector<int>& vec, int v, int l, int r) {
	if (l == r) {
		pos[v] = vec[l] + l;
		neg[v] = vec[l] - l;
		return;
	}
	int m = (l + r) >> 1;
	build(vec, v << 1, l, m);
	build(vec, v << 1 | 1, m+1, r);
	pos[v] = min(pos[v<<1], pos[v<<1|1]);
	neg[v] = min(neg[v<<1], neg[v<<1|1]);
}

void update(int v, int l, int r, int idx, int change) {
	if (l == r) {
		pos[v] = change + idx;
		neg[v] = change - idx;
		return;
	}
	int m = (l + r) >> 1;
	if (idx <= m) update(v << 1, l, m, idx, change);
	else update(v << 1 | 1, m+1, r, idx, change);
	pos[v] = min(pos[v<<1], pos[v<<1|1]);
	neg[v] = min(neg[v<<1], neg[v<<1|1]);
}

pair<int, int> query(int v, int l, int r, int idx) {
	if (l == r) return {pos[v], neg[v]};
	int m = (l + r) >> 1;
	if (idx <= m) return query(v<<1, l, m, idx);
	else return query(v<<1|1, m+1, r, idx);
}

int qp(int v, int l, int r, int idx) {
	// must search >= idx
	if (r < idx) return INF;
	if (l == r) return pos[v];
	if (l >= idx) return pos[v];
	int m = (l + r) >> 1;
	// new ranges are gonna be [l,m] and [m+1,r]
	return min(
		qp(v << 1, l, m, idx),
		qp(v << 1 | 1, m+1, r, idx)
	);
}

int qn(int v, int l, int r, int idx) {
	// must search <= idx
	if (l > idx) return INF;
	if (l == r) return neg[v];
	if (r <= idx) return neg[v];
	int m = (l + r) >> 1;
	// new ranges are gonna be [l,m] and [m+1,r]
	return min(
		qn(v << 1, l, m, idx),
		qn(v << 1 | 1, m+1, r, idx)
	);
}

signed main() {
	int N, Q; cin >> N >> Q;
	vector<int> p(N);
	for (int &x : p) cin >> x;
	build(p, 1, 0, N-1);
	while(Q--) {
		int type, k, x; cin >> type >> k;
		--k;
		if (type == 1) {
			cin >> x;
			update(1, 0, N-1, k, x);
		} else {
			int alpha = qp(1, 0, N-1, k) - k;
			int beta = qn(1, 0, N-1, k) + k;
			cout << min(alpha, beta) << '\n';
		}
	}
}