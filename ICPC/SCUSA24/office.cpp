#include <bits/stdc++.h>
using namespace std;
#define int long long

void rotate(vector<string>& floor) {
	int s = floor.size(), t = floor[0].size();
	vector<string> rotated(t, string(s, '.'));
	for (int i = 0; i < s; i++) {
		for (int j = 0; j < t; j++) {
			rotated[j][s - 1 - i] = floor[i][j];
		}
	}
	floor = rotated;
}

signed main() {
	int r, c, sum = 0; cin >> r >> c;
	vector<vector<int>> lot(r, vector<int>(c));
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> lot[i][j];
			sum += lot[i][j];
		}
	}
	int s, t; cin >> s >> t;
	vector<string> floor(s);
	for (int i = 0; i < s; i++) {
		cin >> floor[i];
	}

	int best = -1;
	for (int iteration = 0; iteration < 4; ++iteration) {
		// test all possible locations
		for (int i = 0; i <= r - floor.size(); i++) {
			for (int j = 0; j <= c - floor[0].size(); j++) {
				int cur = 0;
				for (int x = 0; x < floor.size(); x++) {
					for (int y = 0; y < floor[0].size(); y++) {
						if (floor[x][y] == '#') {
							cur += lot[i + x][j + y];
						}
					}
				}
				// cout << "Placing at (" << i << ", " << j << ") with rotation " << iteration * 90 << " covers " << cur << '\n';
				best = max(best, sum - cur);
			}
		}
		rotate(floor);
	}
	cout << best << '\n';
}

