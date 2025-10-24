#include <bits/stdc++.h>
using namespace std;
#define int long long

struct RMQ {
	int N;
	vector<int> arr;
	vector<int> lg;
	vector<vector<int>> st;
	bool wantMax;

	RMQ() {}
	RMQ(const vector<int>& a, bool wantMax_): arr(a), wantMax(wantMax_) {
		N = (int)arr.size();
		build();
	}

	void build() {
		if (N == 0) return;
		lg.assign(N+1, 0);
		for (int i = 2; i <= N; ++i) lg[i] = lg[i>>1] + 1;
		int K = lg[N] + 1;
		st.assign(K, vector<int>(N));
		for (int i = 0; i < N; ++i) st[0][i] = i;
		for (int k = 1; k < K; ++k) {
			int len = 1 << k;
			int half = 1 << (k-1);
			for (int i = 0; i + len - 1 < N; ++i) {
				int li = st[k-1][i];
				int ri = st[k-1][i + half];
				if (wantMax) {
					st[k][i] = (arr[li] >= arr[ri]) ? li : ri;
				} else {
					st[k][i] = (arr[li] <= arr[ri]) ? li : ri;
				}
			}
		}
	}

	int query(int L, int R) {
		if (L < 0) L = 0;
		if (R >= N) R = N-1;
		if (L > R) return -1;
		if (L + 1 >= R) return -1;
		int len = R - L + 1;
		int k = lg[len];
		int i1 = st[k][L];
		int i2 = st[k][R - (1<<k) + 1];
		if (wantMax) {
			return (arr[i1] >= arr[i2]) ? i1 : i2;
		} else {
			return (arr[i1] <= arr[i2]) ? i1 : i2;
		}
	}
};

int dist(RMQ& stMax, RMQ& stMin, int l, int r) {
	if (l == r) return 0;
	if (l + 1 == r) return 1;
	int pos = stMax.query(l, r);
	if (pos != l && pos != r) {
		return dist(stMax, stMin, l, pos) + dist(stMax, stMin, pos, r);
	} else if (pos == r) {
		int mn = stMin.query(l, r);
		if (mn == l) return 1;
		return dist(stMax, stMin, l, mn) + 1;
	} else {
		int mn = stMin.query(l, r);
		if (mn == r) return 1;
		return 1 + dist(stMax, stMin, mn, r);
	}
}

void solve() {
	int N; cin >> N;
	vector<int> A(N);
	for (int i = 0; i < N; i++) cin >> A[i];
	if (N == 1) {
		cout << "0\n";
		return;
	}

	RMQ stMax(A, true);
	RMQ stMin(A, false);
	cout << dist(stMax, stMin, 0, N-1) << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) solve();
}
