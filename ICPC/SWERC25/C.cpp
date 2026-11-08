#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int t; cin >> t;
	while(t--) {
		// also rmbr this is a permutation so that kinda helps
		int n,m; cin >> n >> m;
		vector<vector<int>> v(n, vector<int>(m));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cin >> v[i][j];
			}
		}
		// casework on odd or even
		if (n&1) {
			// just cycles lol
			for (int i = 0; i < m/2; i++) {
				cout << v[0][i] << ' ';
			}
			int idx = 0;
			int printed = m/2;
			while (printed != (n*m/2)) {
				// find the next thing
				for (int i = 0; i < n; i++) {
					if (v[i][0] == v[idx][m/2]) {
						idx = i;
						for (int j = 0; j < m/2; j++) {
							cout << v[idx][j] << ' ';
						}
						printed += m/2;
						break;
					}
				}
			}
			cout << '\n';
		} else {
			// if n is even we can lowk just do it in whatever order we want LMAO
			vector<bool> seen((n*m/2)+1);
			for (vector<int> sus : v) {
				// can we print sus?
				bool print = true;
				for (int x : sus) {
					if (seen[x]) {
						print = false;
						break;
					}
					seen[x] = true;
				}
				if (print) {
					for (int x : sus) {
						cout << x << ' ';
					}
				}
			}
			cout << '\n';
		}
	}
}