#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
	int N, Q; cin >> N >> Q;
	vector<vector<int>> A(1005, vector<int>(1005, 0));
	for (int i = 0; i < N; i++) {
		int h,w; cin >> h >> w;
		A[h][w] += h * w;
	}
	// 2d pfx sums
	for (int i = 1; i <= 1000; i++) {
		for (int j = 1; j <= 1000; j++) {
			A[i][j] += A[i-1][j] + A[i][j-1] - A[i-1][j-1];
		}
	}
	for (int i = 0; i < Q; i++) {
		int h1, w1, h2, w2; cin >> h1 >> w1 >> h2 >> w2;
		h1++; w1++;
		int ans = A[h2-1][w2-1] - A[h1-1][w2-1] - A[h2-1][w1-1] + A[h1-1][w1-1];
		cout << ans << "\n";
	}
}

signed main() {
	int T; cin >> T;
	while (T--) {
		solve();
	}
}