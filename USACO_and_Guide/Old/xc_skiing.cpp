// 2014 Jan Silver P2

#include <bits/stdc++.h>
using namespace std;

int N, M, A[505][505], X;
vector< pair<int, int> > W;
bool vis[505][505];
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

void flood(int x, int y, int diff) {
	vis[x][y] = true;
	for (int i = 0; i < 4; i++) {
		// set new coords
		int nx = x + dx[i], ny = y + dy[i];

		// first check if this is in bounds
		if (nx <= 0 || nx > N || ny <= 0 || ny > M) continue;

		// check if this is a new loc + diff works
		if (!vis[nx][ny] && abs(A[x][y] - A[nx][ny]) <= diff) {
			flood(nx, ny, diff);
		}
	}
}

int main() {
	freopen("ccski.in", "r", stdin);
	freopen("ccski.out", "w", stdout);
	cin.tie(0)->sync_with_stdio(0);

	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> A[i][j];
		}
	}
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= M; j++) {
			cin >> X;
			if (X == 1) W.push_back({i, j});
		}
	}

	// binary search on the best D value
	int L = 0, R = (int) (1e9+1);
	while(L < R) {
		int M = (L + R) / 2;
		// pick one of the waypoints to floodfill from
		memset(vis, false, sizeof(vis));
		flood(W[0].first, W[0].second, M);

		bool b = true; // test if all waypoints visited
		for (auto p : W) {
		    b &= vis[p.first][p.second];
		    if (!vis[p.first][p.second]) {
		      //  cout << M << " fails on the coords (" << p.first << ", " << p.second << ")\n";
		    }
		}
		if (b) {
			// this works, we can shift the right side
			R = M;
		} else {
			// this doesn't work, so it must be bigger!
			L = ++M;
		}
	}

	cout << L << '\n';
}