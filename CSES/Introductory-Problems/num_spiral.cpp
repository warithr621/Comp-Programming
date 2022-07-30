// CSES Number Spiral

#include <iostream>
#define int long long
using namespace std;
 
int32_t main() {
	int t; cin >> t;
	while(t--) {
		int r,c; cin >> r >> c;
		if (r > c) {
			if (r % 2 == 0) {
				cout << r*r - c + 1;
			} else {
				cout << (r-1)*(r-1) + c;
			}
		} else {
			if (c % 2 == 1) {
				cout << c*c - r + 1;
			} else {
				cout << (c-1)*(c-1) + r;
			}
		}
		cout << '\n';
	}
}