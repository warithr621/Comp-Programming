// 2016 Jan Silver P3

#include <bits/stdc++.h>
using namespace std;

bool fence[4003][4003] = {false}, vis[4003][4003] = {false};
int maxx = 2001, minx = 2001, maxy = 2001, miny = 2001;
int N, X = 2001, Y = 2001; string S;
int dx[] = {0, -1, 0, 1}, dy[] = {1, 0, -1, 0};

void flood(int i, int j) {
	if (i < minx || i > maxx || j < miny || j > maxy) {
		return;
	}
	if (vis[i][j] || fence[i][j]) return;
	
	vis[i][j] = true;
	for (int k = 0; k < 4; k++) {
		flood(i + dx[k], j + dy[k]);
	}
}


int main() {
	freopen("gates.in", "r", stdin);
	freopen("gates.out", "w", stdout);
	cin >> N >> S;
	for (char c : S) {
		// mark all the fences
		int mvx = 0, mvy = 0;
		if (c == 'N') mvx = -1;
		else if (c == 'S') mvx = 1;
		else if (c == 'W') mvy = -1;
		else mvy = 1;
		for (int i = 0; i < 2; i++) {
			X += mvx; Y += mvy;
			fence[X][Y] = true;
		}
		minx = min(minx, X);
		maxx = max(maxx, X);
		miny = min(miny, Y);
		maxy = max(maxy, Y);
	}
	--minx; --miny; // consider the
	++maxx; ++maxy; // outside spaces


	int R = 0; // if there are now R regions, we need R-1 gates
	for (int i = minx; i <= maxx; i++) {
		for (int j = miny; j <= maxy; j++) {
			if (!vis[i][j] && !fence[i][j]) {
				flood(i, j);
				++R;
			}
		}
	}

	cout << --R << endl;
	return 0;
}