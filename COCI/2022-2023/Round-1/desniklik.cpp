// COCI 2022/2023 R1 P1

#include <bits/stdc++.h>
using namespace std;

int main() {
	int T, R, S; cin >> T >> R >> S;
	while(T--) {
		vector<string> a(R);
		for (string& str : a) cin >> str;
		int mn = 100, mx = -1;
		for (int col = 0; col < S; ++col) {
			for (int i = 0; i < R; ++i) {
				if (a[i][col] == '#') {
					mx = max(mx, i);
					mn = min(mn, i);
					break;
				}
			}
		}
		cout << mx - mn << '\n';
	}
}