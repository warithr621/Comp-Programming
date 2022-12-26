// 2022 Open Silver P1

#include <bits/stdc++.h>
#define int long long
using namespace std;

vector<int> a, moos;
vector<vector<int>> graph;
vector<bool> vis;

void dfs(int x) {
	if (vis[x]) return;
	vis[x] = true;
	for (int i : graph[x]) dfs(i);
}

int cycle(int x) {
	int tortoise = x, hare = x;
	do {
		tortoise = a[tortoise];
		hare = a[a[hare]];
	} while (tortoise != hare);

	int mn = INT_MAX;
	do {
		mn = min(mn, moos[tortoise]);
		tortoise = a[tortoise];
	} while (tortoise != hare);
	
	dfs(tortoise);
	return mn;
}


int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	a.resize(n); moos.resize(n); vis.resize(n); graph.resize(n);
	int ans = 0;
	for (int i = 0; i < n; i++) {
		int x,y; cin >> x >> y;
		--x; //because i like 0-indexing

		a[i] = x;
		moos[i] = y;
		ans += y;
		graph[x].push_back(i);

	}
	for (int i = 0; i < n; i++) {
		if (vis[i]) continue;
		ans -= cycle(i);
	}
	
	cout << ans << '\n';
}