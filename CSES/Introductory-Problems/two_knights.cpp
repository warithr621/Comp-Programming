// CSES Two Knights

#include <iostream>
#define int long long
using namespace std;
 
int32_t main() {
	int n; cin >> n;
	for (int k = 1; k <= n; k++) {
		int sq = k * k;
		cout << sq * (sq-1) / 2 - 4 * (k-1) * (k-2);
		cout << '\n';
	}
}