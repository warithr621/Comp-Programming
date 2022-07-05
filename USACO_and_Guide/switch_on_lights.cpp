// 2015 Dec Silver P1

#include <iostream>
#include <vector>
#include <algorithm>
#define int long long
#define pii pair<int, int>
using namespace std;

int n, m, ans = 0;
vector<vector<vector<pii>>> grid;
vector<vector<bool>> vis;
vector<vector<bool>> lit;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, -1, 0, 1};

bool neighbor(int x, int y) {
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i], ny = y + dy[i];
		if (vis[nx][ny] && lit[nx][ny]) return true;
	}
	return false;
}

void search(int x, int y) {
	if (vis[x][y]) return;
	vis[x][y] = true;

	//turn on switches
	for (auto p : grid[x][y]) {
		if (!lit[p.first][p.second]) {
			lit[p.first][p.second] = true;
			//no point in switching it on if it already was :clown:
			if (neighbor(p.first, p.second)) search(p.first, p.second);
		}
	}

	//lastly, search neighbors of the current room itself
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i], ny = y + dy[i];
		if (lit[nx][ny]) search(nx, ny);
	}
}

int32_t main() {
	freopen("lightson.in", "r", stdin);
	freopen("lightson.out", "w", stdout);

	cin >> n >> m;
	grid.resize(n+2); vis.resize(n+2); lit.resize(n+2);
	for (int i = 0; i <= n+1; i++) {
		grid[i] = vector<vector<pii>>(n+2);
		vis[i] = vector<bool>(n+2, false);
		lit[i] = vector<bool>(n+2, false);
	}
	for (int i = 0; i < m; i++) {
		int a,b,c,d; cin >> a >> b >> c >> d;
		grid[a][b].push_back(make_pair(c, d));
	}
	lit[1][1] = true;
	search(1, 1);
	for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) ans += lit[i][j];
	cout << ans << '\n';
}
