#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);

	int n; cin >> n;
	map<string, int> id;
	auto get = [&](const string& s) {
		auto it = id.find(s);
		if (it != id.end()) return it->second;
		int k = id.size();
		id[s] = k;
		return k;
	};

	vector<pair<int,int>> e;
	for (int i = 0; i < n; i++) {
		string name, s, t; cin >> name >> s >> t;
		e.push_back({get(s), get(t)});
	}

	int V = id.size();
	vector<int> nxt(V, -1);
	for (auto [s, t] : e) nxt[s] = t;

	vector<bool> vis(V, false);
	int ans = 0;
	for (int s = 0; s < V; s++) {
		if (vis[s]) continue;
		int cur = s, len = 0;
		while (cur != -1 && !vis[cur]) {
			vis[cur] = true;
			cur = nxt[cur];
			len++;
		}
		if (cur == s) ans = max(ans, len);
	}

	if (ans >= 2) cout << ans << "\n";
	else cout << "No trades possible\n";
}