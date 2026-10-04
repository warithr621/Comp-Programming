#include <bits/stdc++.h>
using namespace std;
 
int main() {
	int n; cin >> n;
	const int BITS = 30;
	int basis[BITS] = {0};
	int rank = 0;
	for (int i = 0; i < n; i++) {
		int x; cin >> x;
		for (int j = BITS-1; j >= 0; j--) {
			int b = (x >> j) & 1;
			if (b) {
				if (!basis[j]) {
					basis[j] = x;
					rank++;
					break;
				} else {
					x ^= basis[j];
				}
			}
		}
	}
	cout << (1 << rank) << '\n';
}