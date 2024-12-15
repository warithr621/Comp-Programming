// CSES Multiplication Table

#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);

	int N;
	cin >> N;
	int L = 1, R = N * N, M;

	while (L < R) {
		M = (L + R) >> 1;
		int cur = 0;
		for (int i = 1; i <= N; i++) {
			cur += min(N, M / i);
		}
		if (cur >= ((N * N + 1) >> 1)) {
			R = M;
		} else {
			L = ++M;
		}
	}
	
	cout << R << '\n';
}