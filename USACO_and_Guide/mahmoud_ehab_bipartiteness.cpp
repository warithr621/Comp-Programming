// https://codeforces.com/contest/862/problem/B

#include <bits/stdc++.h>
using ll = long long;
using namespace std;

int n, color[100005];
vector<int> adj[100005];

void dfs(int pt, int c) {
	if (color[pt]) return;
	color[pt] = 3 - c;
	for (int x : adj[pt]) {
		dfs(x, 3-c);
	}
}

int main() {
	cin >> n;
	for (int i = 1; i < n; i++) {
		int u,v; cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}

	for (int i = 1; i <= n; i++) {
		dfs(i, 1);
	}

	ll one = 0, two = 0;
	for (int i = 1; i <= n; i++) {
		if (color[i] == 1) ++one;
		else ++two;
		// cout << i << ' ' << color[i] << '\n';
	}

	cout << one*two - (n-1) << '\n';
}