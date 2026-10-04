#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = 998244353;

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	// find the cycle in the tree
	// for all pairs (i,j) such that v_i - v_j = k,
	// if (i,j) are both in the cycle, ans += 2
	// otherwise, ans += 1
	// also remember k=0 gonna be freaky
	int n,k; cin >> n >> k;
	vector<int> value(n);
	vector<set<int>> adj(n);
	map<int, vector<int>> mp;
	for (int i = 0; i < n; i++) {
		cin >> value[i];
		mp[value[i]].push_back(i);
	}
	for (int i = 0; i < n; i++) {
		int a,b; cin >> a >> b;
		--a; --b;
		adj[a].insert(b);
		adj[b].insert(a);
	}
	vector<int> dad(n);
	for (int i = 0; i < n; i++) dad[i] = i;
	vector<int> order;
	queue<int> q;
	for (int i = 0; i < n; i++) {
		if (adj[i].size() == 1) q.push(i);
	}
	while (!q.empty()) {
		int u = q.front();
		q.pop();
		order.push_back(u);
		int v = *adj[u].begin();
		dad[u] = v;
		adj[v].erase(u);
		if (adj[v].size() == 1) q.push(v);
	}
	// propogate parents up
	reverse(order.begin(), order.end());
	for (int u : order) dad[u] = dad[dad[u]];

	int adam = 0;
	for (const auto& [vj, vertices] : mp) {
		auto it = mp.find(vj + k);
		if (it != mp.end()) {
			adam += (int) vertices.size() * (int) it->second.size();
		}
	}
	map<pair<int, int>, int> loc;
	for (int i = 0; i < n; i++) {
		loc[{dad[i], value[i]}]++;
	}
	int elly = 0;
	for (int i = 0; i < n; i++) {
		auto it = loc.find({dad[i], value[i] + k});
		if (it != loc.end()) elly += it->second;
	}
	cout << 2 * adam - elly << '\n';
}