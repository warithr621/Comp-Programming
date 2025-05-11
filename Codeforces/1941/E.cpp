#include <bits/stdc++.h>
using namespace std;
#define int long long

int cost[101];

void eval(vector<int>& A, int idx, int M, int D) {
	vector<int> dp(M, (int) (1e9));
	dp[0] = 1;
	multiset<int> ms = {1};
	for (int i = 1; i < M-1; i++) {
		dp[i] = *ms.begin() + A[i] + 1;
		if (i - D - 1 >= 0) ms.erase(ms.find(dp[i - D - 1]));
		ms.insert(dp[i]);
	}
	cost[idx] = 1 + *ms.begin(); // +1 from the last element
}

void solve() {
	int N, M, K, D; cin >> N >> M >> K >> D;
	vector<vector<int>> A(N, vector<int>(M));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> A[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		eval(A[i], i, M, D);
	}

	// for (int i = 0; i < N; i++) {
	// 	cout << cost[i] << ' ';
	// }
	// cout << "~\n";
	
	int cur = 0;
	for (int i = 0; i < K; i++) {
		cur += cost[i];
	}
	int ans = cur;
	for (int i = K; i < N; i++) {
		cur += cost[i] - cost[i - K];
		ans = min(cur, ans);
	}
	cout << ans << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) solve();
}