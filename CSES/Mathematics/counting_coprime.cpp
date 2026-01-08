#include <bits/stdc++.h>
using namespace std;
static const int MAX = 1'000'005;

int mu[MAX + 1];
bool composite[MAX + 1];
vector<int> primes;

void mobius_sieve() {
	mu[1] = 1;
	for (int i = 2; i <= MAX; i++) {
		if (!composite[i]) {
			primes.push_back(i);
			mu[i] = -1;
		}
		for (int p : primes) {
			if ((long long)i * p > MAX) break;
			composite[i * p] = true;
			if (i % p == 0) {
				mu[i * p] = 0;
				break;
			} else {
				mu[i * p] = -mu[i];
			}
		}
	}
}

int skibidi[MAX+1];

void quickmafs(int n) {
	for (int i = 1; i * i <= n; i++) {
		if (n % i == 0) {
			skibidi[i]++;
			if (i * i != n) skibidi[n/i]++;
		}
	}
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	mobius_sieve();
	int n; cin >> n;
	vector<int> a(n);
	for (int &x : a) {
		cin >> x;
	}
	int mx = 0;
	for (int x : a) quickmafs(x), mx = max(mx, x);
	long long ans = 0;
	for (int i = 1; i <= mx; i++) {
		ans += 1LL * mu[i] * skibidi[i] * (skibidi[i]-1) / 2; 
	}
	cout << ans << '\n';
}