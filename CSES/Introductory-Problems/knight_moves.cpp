#include <bits/stdc++.h>
using namespace std;

int ans[1001][1001];
int main() {
	int N; cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			ans[i][j] = (int) 1e9;
		}
	}
	queue<array<int, 3>> bfs; // <x, y, dist>
	bfs.push({0, 0, 0});
	while (!bfs.empty()) {
		auto [x, y, d] = bfs.front(); bfs.pop();
		if (x < 0 || x >= N || y < 0 || y >= N) continue;
		if (ans[x][y] <= d) continue;
		ans[x][y] = d;
		bfs.push({x + 2, y + 1, d + 1});
		bfs.push({x + 2, y - 1, d + 1});
		bfs.push({x - 2, y + 1, d + 1});
		bfs.push({x - 2, y - 1, d + 1});
		bfs.push({x + 1, y + 2, d + 1});
		bfs.push({x + 1, y - 2, d + 1});
		bfs.push({x - 1, y + 2, d + 1});
		bfs.push({x - 1, y - 2, d + 1});
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << ans[i][j] << ' ';
		}
		cout << '\n';
	}
}