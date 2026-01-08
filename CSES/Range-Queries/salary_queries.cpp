#include <bits/stdc++.h>
using namespace std;
 
struct Fenwick {
	int n;
	vector<int> bit;
	int highestPow;
 
	Fenwick(int n) : n(n), bit(n + 1, 0) {
		highestPow = 1;
		while ((highestPow << 1) <= n) highestPow <<= 1;
	}
 
	void add(int i, int v) {
		for (; i <= n; i += i & -i) {
			bit[i] += v;
		}
	}
 
	int sum(int i) {
		int s = 0;
		for (; i > 0; i -= i & -i) {
			s += bit[i];
		}
		return s;
	}

	int query(int a, int b) {
		// a and b are inclusive
		return sum(b) - sum(a-1);
	}
};

struct Query {
	char type;
	int f, s;
	Query(char type, int f, int s) : type(type), f(f), s(s) {}
};
 
int main() {
	int n, q; cin >> n >> q;
	vector<int> p(n);
	for (int &x : p) {
		cin >> x;
	}
	vector<Query> queries;
	while (q--) {
		char t; int f, s;
		cin >> t >> f >> s;
		queries.push_back(Query(t, f, s));
	}

	// coord compress all the numbers?
	vector<int> nums;
	for (int x : p) nums.push_back(x);
	for (auto [t,f,s] : queries) {
		nums.push_back(f);
		nums.push_back(s);
	}
	sort(nums.begin(), nums.end());
	nums.erase(unique(nums.begin(), nums.end()), nums.end());
	n = nums.size();
	unordered_map<int, int> cc;
	for (int i = 0; i < n; i++) {
		cc[nums[i]] = i+1;
	}

	// build the fenwick
	Fenwick fw(n+1);
	for (int x : p) fw.add(cc[x], 1);
	for (auto [t,f,s] : queries) {
		if (t == '!') {
			fw.add(cc[p[f-1]], -1);
			fw.add(cc[s], 1);
			p[f-1] = s;
		} else {
			cout << fw.query(cc[f], cc[s]) << '\n';
		}
	}
}