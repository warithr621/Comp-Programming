// CSES Chessboard and Queens

#include <bits/stdc++.h>
using namespace std;
#define int long long

bool maze[10][10], vis[10][10];
int ans = 0;

bool test(int x, int y) {
	for (int i = 1; i <= 8; ++i) {
		for (int j = 1; j <= 8; j++) {
			if (vis[i][j]) {
				if (abs(i-x) == abs(j-y) || i==x || j==y) return false;
			}
		}
	}

	return true;
}

void dfs(int x) {
	if (x > 8) {
		++ans;
		return;
	}

	for (int i = 1; i <= 8; ++i) {
		if (test(x, i) && maze[x][i]) {
			vis[x][i] = true;
			dfs(x+1);
			vis[x][i] = false;
		}
	}
}

signed main() {
	for (int i = 1; i <= 8; i++) {
		string s; cin >> s;
		for (int j = 1; j <= 8; j++) maze[i][j] = s[j-1] == '.';
	}

	dfs(1);
	cout << ans << '\n';
}