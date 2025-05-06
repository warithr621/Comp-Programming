#include <bits/stdc++.h>
using namespace std;
#define int long long

int N, K, A[300005];
string S;

bool valid(int P) {
	// penalty is the max A[i] among all `i` that are painted incorrectly
	// thus, we can achieve P if all incorrect `i` are at most P
	// alternatively, all `i` such that A[i] > P must be correct
	// any `i` with A[i] <= P can be colored whatever we want
	// so we really only care about the `i` such that A[i] > P and `i` should be B
	// just check how many such segments we can make
	char prev = 'R';
	int ans = 0;
	for (int i = 0; i < N; i++) {
		if (A[i] > P) {
			if (S[i] == 'B' && prev != 'B') ++ans;
			prev = S[i];
		}
	}
	return ans <= K;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) {
		cin >> N >> K >> S;
		for (int i = 0; i < N; i++) cin >> A[i];
		int L = 0, R = (int) (1e9);
		while (L < R) {
			int M = (L + R) >> 1;
			if (valid(M)) R = M;
			else L = M + 1;
		}
		cout << L << '\n';
	}
}