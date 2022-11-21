// 2017 Feb Silver P2

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("maxcross.in", "r", stdin);
	freopen("maxcross.out", "w", stdout);
	int n,k,b; cin >> n >> k >> b;	
	vector<int> a(n, 0);
	for (int i = 0; i < b; i++) {
		int x; cin >> x;
		a[x-1]++;
	}
	vector<int> psum = {0};
	for (int i = 0; i < n; i++) {
		psum.push_back(psum[i] + a[i]);
	}
	int ans = INT_MAX;
	for (int i = 0; i <= n-k; i++) {
		ans = min(ans, psum[i+k] - psum[i]);
	}
	cout << ans << '\n';
}