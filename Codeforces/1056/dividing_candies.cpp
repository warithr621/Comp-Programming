// https://codeforces.com/contest/1056/problem/B

#include <bits/stdc++.h>
#define int long long
using namespace std;

int mod[10000000];

signed main() {
	int n,m; cin >> n >> m;

	/*
	(i^2 + j^2) mod m = 0
	i^2 mod m + j^2 mod m = 0 mod m
	(i mod m)^2 + (j mod m)^2 = 0 mod m
	now we can just test all combinations of i and j I think
	*/

	for (int i = 1; i <= n%m; i++) mod[i*i%m]++;

	vector<int> a;
	for (int i = 0; i < m; i++) a.push_back(i*i%m);
	for (int i : a) mod[i] += n/m;

	int ans = 0;
	for (int i = 0; i < m; i++) ans += mod[i] * mod[(m-i)%m];
	cout << ans << '\n';
}