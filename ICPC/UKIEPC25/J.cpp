#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	// textbook topo sort
	int n; cin >> n;
	vector<vector<int>> adj(26);
	for (int i = 0; i < n; i++) {
		char s, t, dir; cin >> s >> dir >> t;
		if (dir == '<') adj[s - 'a'].push_back(t - 'a');
		else adj[t - 'a'].push_back(s - 'a');
	}
	string s; cin >> s;
	vector<int> freq(26, 0);
	for (char c : s) freq[c - 'a']++;

	// ok now toposort the adj
	vector<int> topo;
	vector<int> indeg(26, 0);
	for (int i = 0; i < 26; i++) {
		for (int j : adj[i]) {
			if (freq[i] && freq[j]) indeg[j]++;
		}
	}
	queue<int> q;
	for (int i = 0; i < 26; i++) {
		if (indeg[i] == 0) q.push(i);
	}
	while (!q.empty()) {
		int u = q.front(); q.pop();
		topo.push_back(u);
		for (int v : adj[u]) {
			if (!freq[u] || !freq[v]) continue;
			indeg[v]--;
			if (indeg[v] == 0) q.push(v);
		}
	}
	int sus = 0;
	for (int i = 0; i < 26; i++) {
		if (indeg[i] > 0) {
			topo.push_back(i);
			if (freq[i] != 0) ++sus;
		}
	}
	if (sus) {
		cout << "IMPOSSIBLE\n";
		return 0;
	}

	for (char c : topo) {
		for (int i = 0; i < freq[c]; i++) cout << char(c + 'a');
	}
	cout << '\n';
}