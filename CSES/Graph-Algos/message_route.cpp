// CSES Message Route

#include <bits/stdc++.h>
using namespace std;

int main() {
	int n,m; cin >> n >> m;
	vector<vector<int>> adj(n+1, vector<int>());
	vector<int> dist(n+1, INT_MAX);
	vector<int> front(n+1, -1);
	for (int i = 0; i < m; i++) {
		int x,y; cin >> x >> y;
		adj[x].push_back(y); adj[y].push_back(x);
	}
	queue<int> q;
	q.push(1); dist[1] = 0;
	while(!q.empty()) {
		int src = q.front(); q.pop();
		for (int i : adj[src]) if (dist[i] == INT_MAX) {
			dist[i] = dist[src] + 1;
			front[i] = src;
			q.push(i);
		}
	}
	if (dist[n] == INT_MAX) cout << "IMPOSSIBLE\n";
	else {
		// for (int i : dist) cout << i << ' ';
		// cout << '\n';
		cout << ++dist[n] << '\n';
		vector<int> path = {n};
		while(path.back() != 1) path.push_back(front[path.back()]);
		reverse(path.begin(), path.end());
		for (int i : path) cout << i << ' ';
	}
}
