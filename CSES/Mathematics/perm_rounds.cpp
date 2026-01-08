#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MOD = 1'000'000'007;
static const int MAXN = 200'005;
int prime[MAXN];

class DSU {
	private:
		vector<int> parents;
		vector<int> sizes;

	public:
		DSU(int size) : parents(size), sizes(size, 1) {
			for (int i = 0; i < size; i++) { parents[i] = i; }
		}

		int find(int x) { return parents[x] == x ? x : (parents[x] = find(parents[x])); }

		bool unite(int x, int y) {
			int x_root = find(x);
			int y_root = find(y);
			if (x_root == y_root) { return false; }

			if (sizes[x_root] < sizes[y_root]) { swap(x_root, y_root); }
			sizes[x_root] += sizes[y_root];
			parents[y_root] = x_root;
			return true;
		}

		bool connected(int x, int y) { return find(x) == find(y); }

		int pp(int x) { return parents[x]; }

		int sz(int x) { return sizes[x]; }
};


void sieve() {
	prime[0] = prime[1] = 1;
	for (int i = 2; i < MAXN; i++) {
		if (prime[i] == 0) {
			for (int j = i*2; j < MAXN; j += i) {
				if (prime[j] == 0) prime[j] = i;
			}
			prime[i] = i;
		}
	}
}

int pw(int base, int exp) {
	if (exp == 0) return 1;
	int p = pw(base, exp>>1) % MOD;
	p = (p * p) % MOD;
	if (exp & 1) p = (p * base) % MOD;
	return p;
}

int lcm(vector<int> arr) {
	unordered_map<int,int> mxmap;
	for (int num : arr) {
		unordered_map<int, int> tmp;
		while (num > 1) {
			int factor = prime[num];
			tmp[factor]++;
			num /= factor;
		}
		for (auto it : tmp) {
			mxmap[it.first] = max(mxmap[it.first], it.second);
		}
	}
	int ans = 1;
	for (auto it : mxmap) {
		ans *= pw(it.first, it.second);
		ans %= MOD;
	}
	return ans;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	sieve();
	int n; cin >> n;
	DSU dsu(n+1);
	for (int i = 1; i <= n; i++) {
		int v; cin >> v;
		dsu.unite(i,v);
	}
	vector<int> awa;
	for (int i = 1; i <= n; i++) {
		if (dsu.pp(i) == i) awa.push_back(dsu.sz(i));
	}
	cout << lcm(awa) << '\n';
}