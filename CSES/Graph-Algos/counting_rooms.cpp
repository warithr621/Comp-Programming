// CSES Counting Rooms

#include <bits/stdc++.h>
using namespace std;

int n,m;
char grid[1001][1001];
int flow[1001][1001];
bool vis[1001][1001];

void flood(int x, int y, int c) {
	if (x < 0 || x >= n) return;
	if (y < 0 || y >= m) return;
	if (flow[x][y] != 0 && flow[x][y] != c) return;
	if (vis[x][y]) return;
	if (grid[x][y] == '#') return;

	vis[x][y] = true;
	flow[x][y] = c;

	flood(x-1, y, c);
	flood(x+1, y, c);
	flood(x, y-1, c);
	flood(x, y+1, c);
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> grid[i][j];
			flow[i][j] = 0;
			vis[i][j] = false;
		}
	}
	
	int color = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!vis[i][j] && grid[i][j] == '.') {
				flood(i, j, color);
				++color;
				// cout << i << ' ' << j << '\n';
			}
		}
	}

	cout << --color << '\n';
// 	for (int i = 0; i < n; i++) {
// 		for (int j = 0; j < m; j++) {
// 			cout << flow[i][j] << ' ';
// 		}
// 		cout << '\n';
// 	}
}
