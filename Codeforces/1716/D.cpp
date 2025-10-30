#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = 998'244'353;

#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")


signed main() {
	cin.tie(0)->sync_with_stdio(0);

	int N,K; cin >> N >> K;
	int V = (int) sqrt(2 * N);
	vector<int> dp(N+1, 0), next(N+1, 0), ans(N+1, 0);
	dp[0] = 1;

	for (int i = 1; i <= V; i++) {
		int step = K + i - 1;
		if (step > N) break;
		fill(next.begin(), next.end(), 0);
		for (int j = 1; j <= N; j++) {
			if (j >= step) {
				next[j] = next[j - step] + dp[j - step];
				if (next[j] >= MOD) next[j] %= MOD;
			}
			(ans[j] += next[j]) %= MOD;
		}
		dp.swap(next);
	}

	for (int i = 1; i <= N; i++) {
		cout << ans[i] << ' ';
	}
	cout << '\n';
}