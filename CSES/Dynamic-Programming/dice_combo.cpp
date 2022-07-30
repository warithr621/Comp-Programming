// CSES Dice Combinations

#include <iostream>
#define int long long
#define MOD 1000000007;
using namespace std;

int32_t main() {
	int n; cin >> n;
	int a[n+1];
	a[0] = 1; a[1] = 1; a[2] = 2; a[3] = 4; a[4] = 8; a[5] = 16;
	for (int i = 6; i <= n; i++) {
		a[i] = 0;
		for(int j = i-6; j < i; j++) a[i] += a[j];
		a[i] %= MOD;
	}
	cout << a[n] << '\n';
}
