#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

int nCr(int n, int r) {
	if (r < 0 || r > n) return 0;
	if (r == 0 || r == n) return 1;
	if (r > n/2) r = n-r;
	int ans = 1;
	for (int i = 1; i <= r; i++) {
		ans = ans * (n-r+i) / i;
	}
	return ans;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	// A -> K ranks
	
	int n; cin >> n;
	vector<int> freq(14), freq2(11);
	for (int i = 0; i < n; i++) {
		char c; cin >> c;

		if (c == 'A') freq[1]++;
		else if (c == 'T') freq[10]++;
		else if (c == 'J') freq[11]++;
		else if (c == 'Q') freq[12]++;
		else if (c == 'K') freq[13]++;
		else freq[c - '0']++;

		if (c == 'A') freq2[1]++;
		else if (c == 'T' || c == 'J' || c == 'Q' || c == 'K') freq2[10]++;
		else freq2[c - '0']++;
		
	}

	int ans = 0;
	// first do 15s
	vector<int> dp(16, 0);
	dp[0] = 1;
	for (int i = 1; i <= 10; i++) {
		for (int j = 15; j >= i; j--) {
			for (int k = 1; k <= freq2[i] && j - k*i >= 0; k++) {
				dp[j] += dp[j - k*i] * nCr(freq2[i], k);
			}
		}
	}
	ans += 2 * dp[15];
	// then do pairs
	for (int x : freq) ans += x * (x-1);
	// then do runs
	for (int l = 1; l <= 13; ) {
		int r = l;
		if (freq[r] == 0) {
			l++;
			continue;
		}
		while (r <= 13 && freq[r] > 0) r++;
		r--;
		if (r - l + 1 >= 3) {
			int len = r - l + 1;
			int cnt = 1;
			for (int i = l; i <= r; i++) {
				cnt *= freq[i];
			}
			ans += cnt * len;
		}
		l = r + 1;
	}

	cout << ans << '\n';
}