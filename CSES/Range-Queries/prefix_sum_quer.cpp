#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MAXN = 200'005;

int S[4*MAXN];
int PS[4*MAXN]; // two segs

void build(vector<int> &A, int v, int l, int r) {
	// cout << v << ' ' << l << ' ' << r << '\n' << flush;
	if (l == r) {
		S[v] = A[l];
		PS[v] = A[l];
		return;
	}
	int m = (l + r) >> 1;
	build(A, 2*v, l, m);
	build(A, 2*v+1, m+1, r);
	S[v] = S[2*v] + S[2*v+1];
	PS[v] = max(PS[2*v], S[2*v] + PS[2*v+1]);
}

void update(int v, int l, int r, int pos, int nxt) {
	if (l == r) {
		S[v] = nxt;
		PS[v] = nxt;
		return;
	}
	int m = (l + r) >> 1;
	if (pos <= m) update(2*v, l, m, pos, nxt);
	else update(2*v+1, m+1, r, pos, nxt);
	S[v] = S[2*v] + S[2*v+1];
	PS[v] = max(PS[2*v], S[2*v] + PS[2*v+1]);
}

pair<int,int> query(int v, int l, int r, int left, int right) {
	if (left > r or right < l) return {0,0};
	if (left <= l and right >= r) return {S[v], PS[v]};
	int m = (l + r) >> 1;
	auto p1 = query(2*v, l, m, left, right);
	auto p2 = query(2*v+1, m+1, r, left, right);
	return {
		p1.first + p2.first,
		max(p1.second, p1.first + p2.second)
	};
}


signed main() {
	int N, Q; cin >> N >> Q;
	vector<int> A(N);
	for (int &x : A) cin >> x;
	build(A, 1, 0, N-1);
	while (Q--) {
		int t, a, b; cin >> t >> a >> b;
		if (t == 1) {
			// update a (1-indexed) to b
			A[a-1] = b;
			update(1, 0, N-1, a-1, b);
		} else {
			// max psum in the interval [a,b]
			cout << max(query(1, 0, N-1, a-1, b-1).second, 0LL) << '\n';
		}
	}
}