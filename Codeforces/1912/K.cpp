#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MOD = 998244353;
const int INV2 = (MOD + 1) >> 1;

signed main() {
	// EOO, OEO, OOE, EEE
	int N; cin >> N;
	vector<int> A(N);
	for (int i = 0; i < N; i++) {
		cin >> A[i];
		A[i] &= 1; // only care abt odd vs even
	}
	// let dp[i][j] be 
		// no. of harmonious subsequences ending at 'i'
		// of "flavor" 'j'
	// dp[0] = 0, dp[1] = 0 (obviously)
	// if A[i] is even, we get (E = even bef, O = odd bef)
		// E * (E-1) / 2
		// O * (O - 1) / 2
		// dp[prev][0] + dp[prev][3]
	// if A[i] is odd,
		// O * E <-- consider 01 and 10 separately i think
		// dp[prev][1] + dp[prev][2]

	int oCount = A[0] + A[1];
	int eCount = 2 - oCount;
	int pairs01 = (A[0] == 0 and A[1] == 1 ? 1 : 0);
	int pairs10 = (A[0] == 1 and A[1] == 0 ? 1 : 0);;
	vector<int> running = {0, 0, 0, 0};
	for (int i = 2; i < N; i++) {
		vector<int> cur(4, 0);
		if (A[i]) {
			cur[0] += pairs01 % MOD;
			cur[1] += pairs10 % MOD;

			cur[0] = (cur[0] + running[1]) % MOD;
			cur[1] = (cur[1] + running[2]) % MOD;
		} else {
			cur[3] = (cur[3] + eCount * (eCount - 1) % MOD * INV2 % MOD) % MOD;
			cur[2] = (cur[2] + oCount * (oCount - 1) % MOD * INV2 % MOD) % MOD;

			cur[2] = (cur[2] + running[0]) % MOD;
			cur[3] = (cur[3] + running[3]) % MOD;
		}
		if (A[i]) {
			pairs01 += eCount;
			oCount++;
		} else {
			eCount++;
			pairs10 += oCount;
		}
		for (int j = 0; j < 4; j++) {
			running[j] = (running[j] + cur[j]) % MOD;
		}
	}
	int ans = 0;
	for (int x : running) {
		ans = (ans + x) % MOD;
	}
	cout << ans << '\n';
}