#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, m; cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			char c; cin >> c;
			if ((i + j) % 2 == 0) {
				cout << (c == 'B' ? 'A' : 'B');
			} else {
				cout << (c == 'D' ? 'C' : 'D');
			}
		}
		cout << '\n';
	}
}