#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

const int INF = LLONG_MAX / 4;

struct MCMF {
	struct edge { int from, to, rev, cap, cost, flow; };
	int N;
	vector<vector<edge>> ed;
	vector<int> seen, dist, pi;
	vector<edge*> par;
	MCMF(int N) : N(N), ed(N), seen(N), dist(N), pi(N), par(N) {}

	void addEdge(int from, int to, int cap, int cost) {
		if (from == to) return;
		ed[from].push_back({from, to, (int)ed[to].size(), cap, cost, 0});
		ed[to].push_back({to, from, (int)ed[from].size() - 1, 0, -cost, 0});
	}

	void path(int s) {
		fill(seen.begin(), seen.end(), 0);
		fill(dist.begin(), dist.end(), INF);
		dist[s] = 0;
		par[s] = nullptr;
		priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> q;
		q.push({0, s});
		while (!q.empty()) {
			auto [d,u] = q.top(); q.pop();
			if (seen[u]) continue;
			seen[u] = 1;
			for (edge &e : ed[u]) {
				if (seen[e.to] || e.cap - e.flow <= 0) continue;
				int val = d + pi[u] - pi[e.to] + e.cost;
				if (val < dist[e.to]) {
					dist[e.to] = val;
					par[e.to] = &e;
					q.push({val, e.to});
				}
			}
		}
		for (int i = 0; i < N; i++) pi[i] = min(pi[i] + dist[i], INF);
	}

	pair<int,int> maxflow(int s, int t) {
		int totflow = 0, totcost = 0;
		while (path(s), seen[t]) {
			int fl = INF;
			for (edge *e = par[t]; e; e = par[e->from]) fl = min(fl, e->cap - e->flow);
			for (edge *e = par[t]; e; e = par[e->from]) {
				e->flow += fl;
				ed[e->to][e->rev].flow -= fl;
				totcost += fl * e->cost;
			}
			totflow += fl;
		}
		return {totflow, totcost};
	}
};

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	// i think this should be like
	// first, find the shortest dist between any pair of warehouses
	// then for each (item,warehouse) pair, find the cost needed to move all the items to that warehouse
	// for each item keep the best warehouse
	// take the M smallest numbers and add them

	int n, m; cin >> n >> m;
	vector<vector<int>> warehouses(n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int x; cin >> x;
			warehouses[i].push_back(x);
		}
	}
	vector<vector<int>> dist(n, vector<int>(n, INF));
	for (int i = 0; i < n; i++) {
		dist[i][i] = 0;
		for (int j = 0; j < n; j++) {
			int w; cin >> w;
			if (w != -1 && i != j) dist[i][j] = w;
		}
	}
	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			if (dist[i][k] == INF) continue;
			for (int j = 0; j < n; j++) {
				if (dist[k][j] != INF) dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
			}
		}
	}

	vector<vector<int>> pairs(n, vector<int>(m));
	// pairs[i][j] is the min cost to move all items of type j to warehouse i
	for (int src = 0; src < n; src++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pairs[i][j] == INF || warehouses[src][j] == 0) continue;
				if (dist[src][i] == INF) pairs[i][j] = INF; // can't get there
				else pairs[i][j] += dist[src][i] * warehouses[src][j];
			}
		}
	}

	// now for each item, keep only the best warehouse
	// can you model this as flow??
	// like the sources are each product j with capacity 1
	// the sinks are each warehouse with capacity 1
	// the flows are product j -> warehouse i, which has capacity 1 and cost pairs[i][j]
	// then push m units of flow and MCMF it

	int S = 0, T = m + n + 1;
	MCMF mf(m + n + 2);
	for (int j = 0; j < m; j++) mf.addEdge(S, 1+j, 1, 0);
	for (int i = 0; i < n; i++) mf.addEdge(m+1+i, T, 1, 0);
	for (int j = 0; j < m; j++) {
		for (int i = 0; i < n; i++) {
			if (pairs[i][j] < INF) mf.addEdge(1+j, m+1+i, 1, pairs[i][j]);
		}
	}
	cout << mf.maxflow(S, T).second << '\n';
}