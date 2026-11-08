#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	// same number diff row diff col
	int n; cin >> n;
	while (n--) {
		vector<vector<int>> a(2, vector<int>(5));
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				cin >> a[i][j];
			}
		}
		string works = "NO";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				for (int y = 0; y < 5; y++) {
					if (j == y) continue;
					if (a[i][j] == a[i^1][y]) works = "YES";
				}
			}
		}
		cout << works << '\n';
	}
}