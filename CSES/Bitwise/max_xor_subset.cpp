#include <bits/stdc++.h>
using namespace std;
 
int main() {
	int n; cin >> n;
	const int BITS = 30;
	int basis[BITS] = {0};
	for (int i = 0; i < n; i++) {
		int x; cin >> x;
		for (int j = BITS-1; j >= 0; j--) {
			int b = (x >> j) & 1;
			if (b) {
				if (!basis[j]) {
					basis[j] = x;
					break;
				} else {
					x ^= basis[j];
				}
			}
		}
	}
	int ans = 0;
	for (int i = BITS-1; i >= 0; i--) {
		ans = max(ans, ans ^ basis[i]);
	}
	cout << ans << '\n';
}