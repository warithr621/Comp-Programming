// https://codeforces.com/contest/1741/problem/C

#include <bits/stdc++.h>
using namespace std;

int N, A[2005];

int test(int start, int sum) {
	if (start == N) return 0;
	for (int j = start + 1, cur = 0; j <= N; ++j) {
		cur += A[j - 1];
		if (cur > sum) return N;
		if (cur == sum) return max(j - start, test(j, sum));
	}
	return N;
}

void solve() {
    cin >> N;
    for (int i = 0; i < N; i++) cin >> A[i];
	int ans = N;
	for (int len = 1, sum = 0; len < N; ++len) {
		sum += A[len - 1];
		ans = min(ans, test(0, sum));
	}
	cout << ans << '\n';
}

int main() {
	int T; cin >> T;
	while(T--) solve();
}