// 2016 Jan Silver P1

#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>
#define int long long
using namespace std;

int32_t main() {
	freopen("angry.in", "r", stdin);
	freopen("angry.out", "w", stdout);
	cin.tie(0)->sync_with_stdio(0);
	int n,k; cin >> n >> k;
	vector<int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];
	sort(a.begin(), a.end());
	int L = 1, R = 500000000;
	while(L < R) {
		int M = (L + R) / 2;
		int used = 1;
		int cur = a[0] + 2 * M;
		for(int i = 0; i < n; i++) {
			if (a[i] <= cur) continue;
			++used;
			cur = a[i] + 2 * M;
		}
		if (used > k) L = M+1;
		else R = M;
	}
	cout << L << '\n';
}