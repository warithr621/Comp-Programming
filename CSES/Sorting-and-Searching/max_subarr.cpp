// CSES Max Subarray Sum

#include <bits/stdc++.h>
using namespace std;
#define int long long

int32_t main() {
	int n; cin >> n;
	vector<int> a(n); //initial
	for (int i = 0; i < n; i++) cin >> a[i];
	vector<int> p(n+1, 0); //prefix sum
	for (int i = 1; i <= n; i++) p[i] = p[i-1] + a[i-1];
// 	for (int i : p) cout << i << ' ';
// 	cout << '\n';
	vector<int> mindex(n+1, 0); //stores the index with the smallest value to the left of 'i' in vector p
	for (int i = 2; i <= n; i++) {
	    if (p[mindex[i-1]] < p[i-1]) mindex[i] = mindex[i-1];
	    else mindex[i] = i-1;
	}
// 	for (int i : mindex) cout << i << ' ';
// 	cout << '\n';
	int ans = INT_MIN;
	for (int i = 1; i <= n; i++) ans = max(ans, p[i] - p[mindex[i]]);
	cout << ans << '\n';
}
