#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	// i claim that I can just pq this
	int n,k; cin >> n >> k;
	auto cmp = [](int a, int b) {
		cout << "? " << a << " " << b << endl;
		int res; cin >> res;
		if (res == a) return 1;
		else return 0;
	};
	priority_queue<int, vector<int>, decltype(cmp)> pq;

	for (int i = 1; i <= n; i++) {
		pq.push(i);
		if (pq.size() > k) pq.pop();
	}
	vector<int> res;
	while (!pq.empty()) {
		res.push_back(pq.top());
		pq.pop();
	}
	cout << "!";
	for (int x : res) cout << ' ' << x;
	cout << endl;
}