// USACO Trainer's "Arithmetic Progressions"

/*
ID: REDACTED
LANG: C++11
TASK: ariprog
*/


#include <bits/stdc++.h>
using namespace std;

bool bis[130000];

int main() {
	freopen("ariprog.in", "r", stdin);
	int n,m; cin >> n >> m;
	int mx = m * m * 2;
	vector<pair<int, int>> results;
	for (int i = 0; i <= m; i++) {
		for (int j = 0; j <= m; j++) bis[i*i + j*j] = true;
	}
	
	for (int i = 0; i < mx; i++) {
		if (!bis[i]) continue;
		bool b = false;
		for (int j = 1; j <= (mx - i) / (n - 1); j++) {
			b = false;
			for (int k = 1; k <= n-1; k++) {
				if (!bis[i+j*k]) {
					b = true; break;
				}
			}
			if (b) continue;
			results.push_back({j, i});
		}
	}
	sort(results.begin(), results.end());

	freopen("ariprog.out", "w", stdout);
	if (results.size() > 0) {
		for (auto p : results) cout << p.second << ' ' << p.first << '\n';
	} else cout << "NONE\n";
}