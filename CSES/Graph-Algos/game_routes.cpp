#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MOD = (int) (1e9+7);

vector<int> kahn(int V, vector<vector<int>>& adj) {
	vector<int> inDegree(V, 0);
	vector<int> result;
	queue<int> q;
	for (int u = 0; u < V; u++) {
		for (int v : adj[u]) {
			inDegree[v]++;
		}
	}
	for (int i = 0; i < V; i++) {
		if (inDegree[i] == 0) {
			q.push(i);
		}
	}
	while (!q.empty()) {
		int u = q.front();
		q.pop();
		result.push_back(u);
		for (int v : adj[u]) {
			if (--inDegree[v] == 0) {
				q.push(v);
			}
		}
	}

	if (result.size() != V) {
		return {}; // cycle detection
	}

	return result;
}


signed main() {
	int n,m; cin >> n >> m;
	vector<vector<int>> graph(n+1, vector<int>());
	while(m--) {
		int a,b; cin >> a >> b;
		graph[a].push_back(b);
	}
	int cnt[n+1];
	fill(cnt, cnt + n + 1, 0);
	cnt[1] = 1;
	vector<int> ts = kahn(n+1, graph);	
	for (int src : ts) {
		for (int dest : graph[src]) {
			cnt[dest] = (cnt[dest] + cnt[src]) % MOD;
		}
	}
	cout << cnt[n] << '\n';
}