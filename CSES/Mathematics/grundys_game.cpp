// CSES Grundy's Game

#include <bits/stdc++.h>
using namespace std;

int dp[1000005], N, T;

void solve() {
	cin >> N;
	if (N >= 2000) cout << "first" << '\n'; // random lower bound yaw
	else cout << (dp[N] == 0 ? "second" : "first") << '\n';
}

int func(vector<int> v) {
	set<int> s;
	for (int x : v) s.insert(x);
	for (int i = 0; i <= (int) (1e6); i++) {
		if (s.count(i) == 0) return i;
	}
	return -1;
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	for (int i = 0; i <= 2; i++) dp[i] = 0; // initial values
	for (int i = 3; i <= 2000; i++) {
		int L = 1, R = i-1;
		vector<int> v;
		while (L < R) {
			v.push_back(dp[L] ^ dp[R]);
			++L;
			--R;
		}
		dp[i] = func(v);
	}

	cin >> T;
	while (T-->0) solve();
}