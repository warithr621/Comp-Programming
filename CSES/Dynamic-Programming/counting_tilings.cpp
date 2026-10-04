#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = 1e9 + 7;
#pragma GCC optimize("O2")

int n, m;
int dp[1<<10][1001];

void fillCol(int pos, int cur, int nxt, function<void(int)> onComplete) {
	if (pos == n) {
		onComplete(nxt);
		return;
	}
	if (cur & (1 << pos)) {
		fillCol(pos + 1, cur, nxt, onComplete);
		return;
	}
	// use a vertical tile
	if (pos + 1 < n && !(cur & (1 << (pos + 1)))) {
		fillCol(pos + 2, cur | (1 << pos) | (1 << (pos + 1)), nxt, onComplete);
	}
	// use a horizontal tile
	// since we're processing rows top->bottom, this is always possible (no if needed)
	fillCol(pos + 1, cur | (1 << pos), nxt | (1 << pos), onComplete);
}

signed main() {
	cin >> n >> m;
	// dp[i][j] = first j cols are filled out, (j+1)th col has bitmask config i
	dp[0][0] = 1;

	for (int j = 0; j < m; j++) {
		for (int i = 0; i < (1<<n); i++) {
			if (dp[i][j] == 0) continue;
			fillCol(0, i, 0, [&](int newmask) {
				dp[newmask][j+1] = (dp[newmask][j+1] + dp[i][j]) % MOD;
			});
		}
	}
	cout << dp[0][m] << '\n';
}
