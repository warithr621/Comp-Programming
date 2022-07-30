// CSES Labyrinth

#include <bits/stdc++.h>
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n,m; cin >> n >> m;
	char grid[n][m];
	int Ax = 0, Ay = 0, Bx = 0, By = 0;
	for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
		cin >> grid[i][j];
		if (grid[i][j] == 'A') {
			Ax = i; Ay = j;
		} else if (grid[i][j] == 'B') {
			Bx = i; By = j;
		}
	}
	
	int dx[] = {0, -1, 0, 1};
	int dy[] = {1, 0, -1, 0};
	string move[] = {"R", "U", "L", "D"};
	
	queue<pair<int, int>> q;
	q.push(make_pair(Ax, Ay));
	vector<vector<bool>> vis(n, vector<bool>(m, false));
	vis[Ax][Ay] = true;
	vector<vector<int>> prev(n, vector<int>(m));
	
	while(!q.empty()) {
		pair<int, int> P = q.front(); q.pop();
		int x = P.first, y = P.second;
		// cout << x << ' ' << y << '\n';
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			// cout << nx << ' ' << ny << '\n';
			if (nx < 0 || nx >= n) continue;
			if (ny < 0 || ny >= m) continue;
			if (vis[nx][ny]) continue;
			if (grid[nx][ny] == '#') continue;
			vis[nx][ny] = true;
			q.push(make_pair(nx, ny));
			prev[nx][ny] = i;
			// cout << "ADDED: " << nx << ' ' << ny << '\n';
		}
		// cout << '\n';
	}
	// for (int i = 0; i < n; i++) {
	// 	for (int j = 0; j < m; j++) cout << vis[i][j];
	// 		cout << '\n';
	// }
	if (!vis[Bx][By]) cout << "NO\n";
	else {
		cout << "YES\n";
		vector<string> path;
		pair<int, int> cur = make_pair(Bx, By);
		while(cur.first != Ax || cur.second != Ay) {
			int step = prev[cur.first][cur.second];
			path.push_back(move[step]);
			int nx = cur.first - dx[step];
			int ny = cur.second - dy[step];
			cur = make_pair(nx, ny);
		}
		cout << path.size() << '\n';
		reverse(path.begin(), path.end());
		for (string s : path) cout << s;
	}
}
