#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MAXP = 100000;
vector<int> primes;

void compute_primes() {
	vector<bool> is_prime(MAXP + 1, true);
	is_prime[0] = is_prime[1] = false;
	for (int i = 2; i <= MAXP; i++) {
		if (is_prime[i]) {
			primes.push_back(i);
			for (int j = i * i; j <= MAXP; j += i) {
				is_prime[j] = false;
			}
		}
	}
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	compute_primes();

	int T; cin >> T;
	while (T--) {
		int N; cin >> N;
		vector<int> A(N);
		for (int &x : A) {
			cin >> x;
		}
		unordered_set<int> seen_primes;
		bool works = false;
		for (int V : A) {
			int original = V;
			for (int p : primes) {
				if (p * p > V) break;
				if (V % p == 0) {
					if (seen_primes.count(p)) {
						works = true;
						break;
					}
					seen_primes.insert(p);
					while (V % p == 0) V /= p;
				}
			}
			if (works) break;
			if (V > 1) {
				if (seen_primes.count(V)) {
					works = true;
					break;
				}
				seen_primes.insert(V);
			}
		}
		cout << (works ? "YES" : "NO") << '\n';
	}
}