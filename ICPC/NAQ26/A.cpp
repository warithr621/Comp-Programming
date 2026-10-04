#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MOD = 998244353;

signed main() {
	int n; cin >> n;
	// sum of first n triangular numbers
	// n(n+1)(n+2)/6 i think?
	int INV = 166374059; // 1/6
	cout << (n%MOD) * ((n+1)%MOD)%MOD * ((n+2)%MOD)%MOD * INV%MOD;
	
}