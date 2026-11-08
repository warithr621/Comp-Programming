#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n; cin >> n;
	int ans = n/2;
	while (gcd(n, ans) != 1) ++ans;
	cout << ans << '\n';
}