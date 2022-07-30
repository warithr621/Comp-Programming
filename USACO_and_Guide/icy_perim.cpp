// 2019 Jan Silver P2

#include <bits/stdc++.h>
using namespace std;

int n;
char grid[1001][1001];
int flow[1001][1001];
bool vis[1001][1001];

void flood(int x, int y, int c) {
	if (x < 0 || x >= n) return;
	if (y < 0 || y >= n) return;
	if (flow[x][y] != 0 && flow[x][y] != c) return;
	if (vis[x][y]) return;
	if (grid[x][y] == '.') return;

	vis[x][y] = true;
	flow[x][y] = c;

	flood(x-1, y, c);
	flood(x+1, y, c);
	flood(x, y-1, c);
	flood(x, y+1, c);
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	freopen("perimeter.in", "r", stdin);
	freopen("perimeter.out", "w", stdout);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> grid[i][j];
			flow[i][j] = 0;
			vis[i][j] = false;
		}
	}
	
	int color = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!vis[i][j] && grid[i][j] == '#') {
				flood(i, j, color);
				++color;
			}
		}
	}

	// for (int i = 0; i < n; i++) {
	// 	for (int j = 0; j < n; j++) {
	// 		cout << flow[i][j];
	// 	}
	// 	cout << '\n';
	// }

	vector<int> area(color+1, 0), perimeter(color+1, 0);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			area[flow[i][j]]++;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int region = flow[i][j];
			if (i == 0 || grid[i-1][j] == '.') {
				//top is good
				++perimeter[region];
			}

			if (i == n-1 || grid[i+1][j] == '.') {
				//bottom is good
				++perimeter[region];
			}

			if (j == 0 || grid[i][j-1] == '.') {
				//left is good
				++perimeter[region];
			}

			if (j == n-1 || grid[i][j+1] == '.') {
				//right is good
				++perimeter[region];
			}
		}
	}


	int A = -1, P = INT_MAX;
	for (int i = 1; i <= color; i++) {
		if (area[i] > A || (area[i] == A && perimeter[i] < P)) {
			A = area[i];
			P = perimeter[i];
		}
	}
	cout << A << ' ' << P << '\n';
}