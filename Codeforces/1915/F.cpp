#include <bits/stdc++.h>
using namespace std;
#define int long long

// THERE IS NO WAY I NEED FENWICK / OST FOR THIS PROBLEM
struct Fenwick {
	vector<int> bit;
	int n;
	Fenwick(int n) : n(n), bit(n+1) {}
	void update(int i, int delta) {
		for (++i; i <= n; i += i & -i) bit[i] += delta;
	}
	int query(int i) {
		int res = 0;
		for (++i; i > 0; i -= i & -i) res += bit[i];
		return res;
	}
	int range_query(int l, int r) {
		return query(r) - query(l-1);
	}
};

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T--) {
		int N; cin >> N;
		vector<pair<int, int>> people(N);
		vector<int> coords;
		for (int i = 0; i < N; i++) {
			int A, B;
			cin >> A >> B;
			people[i] = {A, B};
			coords.push_back(A);
			coords.push_back(B);
		}
		
		sort(coords.begin(), coords.end());
		coords.erase(unique(coords.begin(), coords.end()), coords.end());
		auto compress = [&](int x) {
			return lower_bound(coords.begin(), coords.end(), x) - coords.begin();
		};
		for (auto& [a, b] : people) {
			a = compress(a);
			b = compress(b);
		}

		sort(people.begin(), people.end(), [](auto &a, auto &b) {
			if (a.first != b.first) return a.first < b.first;
			return a.second > b.second;
		});

		Fenwick bit(2 * N);
		int ans = 0;
		for (auto &[a, b] : people) {
			ans += bit.range_query(b + 1, 2*N - 1); // B[j] > B[i]
			bit.update(b, 1); // insert B[i]
		}
		cout << ans << '\n';
	}
}