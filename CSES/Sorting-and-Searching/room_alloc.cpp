#include <bits/stdc++.h>
using namespace std;
#define int long long
#define pii pair<int, int>
#define f first
#define s second

signed main() {
	int n; cin >> n;
	vector<array<int, 3>> c(n);
	for (int i = 0; i < n; i++) {
		int a, b; cin >> a >> b;
		c[i] = {a, b, i};
	}
	sort(c.begin(), c.end());
	priority_queue<pii, vector<pii>, greater<pii>> pq;
	int cnt = 0;
	vector<int> ans(n);
	for (int i = 0; i < n; i++) {
		int a = c[i][0], b = c[i][1], idx = c[i][2];
		if (pq.empty() || pq.top().f >= a) {
			pq.push({b, ++cnt});
			ans[idx] = cnt;
		} else {
			auto [end, number] = pq.top();
			pq.pop();
			pq.push({b, number});
			ans[idx] = number;
		}
	}
	cout << cnt << '\n';
	for (int x : ans) cout << x << ' ';
	cout << '\n';
}