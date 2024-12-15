// CSES Throwing Dice

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define vi vector<int>
#define vv vector<vi>
const int MOD = (int) (1e9) + 7;

vv mult(vv a, vv b) {
	vv ans(6, vi(6, 0));
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 6; k++) {
				ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % MOD;
			}
		}
	}
	return ans;
}

vv exp(vector< vector<int> > matrix, int n) {
	vv res = {
		{1, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0},
		{0, 0, 1, 0, 0, 0},
		{0, 0, 0, 1, 0, 0},
		{0, 0, 0, 0, 1, 0},
		{0, 0, 0, 0, 0, 1}
	};;
	while (n > 0) {
		if (n & 1) {
			// multiply current and matrix
			res = mult(res, matrix);
		}
		// square matrix
		matrix = mult(matrix, matrix);
		n >>= 1;
	}
	return res;
}

int solve(int n) {
	vi cur = {1, 2, 4, 8, 16, 32};
	if (n <= 6)
		return cur[n-1];
	// otherwise, do binary exponentiation
	vv transform = {
		{1, 1, 1, 1, 1, 1},
		{1, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0},
		{0, 0, 1, 0, 0, 0},
		{0, 0, 0, 1, 0, 0},
		{0, 0, 0, 0, 1, 0}
	};
	transform = exp(transform, n - 6);
	// for (int i = 0; i < 6; i++) {
	// 	for (int j = 0; j < 6; j++) {
	// 		cout << transform[i][j] << ' ';
	// 	}
	// 	cout << '\n';
	// }
	int ans = 0;
	for (int i = 0; i < 6; i++)
		ans = (ans + transform[0][i] * cur[5 - i]) % MOD;
	
	return ans;
}

signed main() {
	int n; cin >> n;
	cout << solve(n) << '\n';
}