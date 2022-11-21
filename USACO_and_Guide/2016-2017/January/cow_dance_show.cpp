// 2017 Jan Silver P1

#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <queue>
#define int long long
using namespace std;

int32_t main() {
	freopen("cowdance.in", "r", stdin);
	freopen("cowdance.out", "w", stdout);
	cin.tie(0)->sync_with_stdio(0);
	
	int n,t; cin >> n >> t;
	vector<int> d(n);
	for (int i = 0; i < n; i++) cin >> d[i];
	int L = 1, R = n;
	while (L < R) {
		int M = (L + R) / 2;
		int time = 0;
		priority_queue<int, vector<int>, greater<int>> q;
		bool b = true;
		for (int i = 0; i < n; i++) {
			if (q.size() == M) {
				time = q.top();
				q.pop();
			}
			if (time + d[i] > t) {
				b = false;
				break;
			}
			q.push(time + d[i]);
		}
		if (b) R = M;
		else L = ++M;
	}
	cout << L << '\n';
}