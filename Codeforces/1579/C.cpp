// https://codeforces.com/contest/1579/problem/C

#include <iostream>
using namespace std;

void solve() {
	int n,m,k; cin >> n >> m >> k;
	int a[n][m], fin[n][m];
	for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
		char c; cin >> c;
		a[i][j] = (c == '*' ? 1 : 0);
		fin[i][j] = 0;
	}
	//'a' is the original, 'fin' is after we flood as much as we can
	//ideally, 'a' = 'fin'
	for (int i = n-1; i >= 0; i--) {
		for (int j = m-1; j >= 0; j--) {
			//we wanna start at the lowest point and build up
			if (a[i][j]) {
				int lx = i, ly = j, rx = i, ry = j;
				while(lx > 0 && ly > 0 && a[lx-1][ly-1]) {
					--lx; --ly;
				}
				while(rx > 0 && ry < m-1 && a[rx-1][ry+1]) {
					--rx; ++ry;
				}
				//the ticks have to be even on each side, so take the min of the dist
				if (i - rx > i - lx) {
					//set based on the L distance
					rx = lx; ry = 2 * j - ly;
				} else {
					//set based on the R distance
					lx = rx; ly = 2 * j - ry;
				}
				int dist = i - rx;
				// cout << i << ' ' << j << ' ' << dist << '\n';
				if (dist < k) {
					continue;
				}
				//now build the tick
				for (int ch = 0; ch <= dist; ch++) {
					fin[i-ch][j-ch] = fin[i-ch][j+ch] = 1;
				}
			}
		}
	}
	//double check to make sure that the orig matches the fin
	// for (int i = 0; i < n; i++) {
	// 	for (int j = 0; j < m; j++) {
	// 		cout << a[i][j];
	// 	}
	// 	cout << '\n';
	// }
	// for (int i = 0; i < n; i++) {
	// 	for (int j = 0; j < m; j++) {
	// 		cout << fin[i][j];
	// 	}
	// 	cout << '\n';
	// }
	for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
		if (a[i][j] != fin[i][j]) {
			cout << "No\n"; return;
		}
	}
	cout << "yES\n";
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int t; cin >> t; while(t--) solve();
}
