// https://codeforces.com/problemset/problem/888/D

#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main() {
	int n,k; cin >> n >> k;
	int d[5]; d[0] = 1;
	for (int i = 1; i <= 4; i++) {
		d[i] = d[i-1] * i + (i & 1 ? -1 : 1);
	}
	int ans = 0;
	for (int i = 0; i <= k; i++) {
		int tmp = 1;
		for (int j = 0; j < i; j++) tmp *= n - j;
		for (int j = 1; j <= i; j++) tmp /= j;
		tmp *= d[i];
		ans += tmp;
	}
	cout << ans << '\n';
}