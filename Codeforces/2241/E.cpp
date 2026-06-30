%:include <bits/stdc++.h>
using namespace std;
%:define int long long
%:define pb push_back

const int MAXA = 1000005;
bool sq[MAXA];

void pcomp() {
	for (int i = 0; i * i < MAXA; i++) sq[i * i] = 1;
}

void solve() <%
	//code
	int n; cin >> n;
	vector<int> a(n);
	for (int &x : a) {
		cin >> x;
	}
	vector<vector<int>> adj(n);
	for (int i = 0; i < n-1; i++) {
		int u,v; cin >> u >> v;
		--u; --v;
		adj[u].pb(v);
		adj[v].pb(u);
	}

	vector<int> parent(n, -1), order;
	order.reserve(n);
	stack<int> st;
	st.push(0);
	while (!st.empty()) {
		int u = st.top();
		st.pop();
		order.pb(u);
		for (int v : adj[u]) {
			if (v == parent[u]) continue;
			parent[v] = u;
			st.push(v);
		}
	}
	vector<int> subtree(n, 1);
	for (int i = n - 1; i >= 0; i--) {
		int u = order[i];
		if (parent[u] != -1) {
			subtree[parent[u]] += subtree[u];
		}
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		if (!sq[a[i]]) continue;
		vector<int> comps;
		for (int v : adj[i]) {
			if (v == parent[i]) {
				comps.pb(n - subtree[i]);
			} else {
				comps.pb(subtree[v]);
			}
		}
		int dp0 = 1, dp1 = 0, dp2 = 0, dp3 = 0;
		for (int c : comps) { // fancy hehe
			dp3 += dp2 * c;
			dp2 += dp1 * c;
			dp1 += dp0 * c;
		}
		ans += dp2 + dp3;
	}
	cout << ans << "\n";
%>
 
signed main() <%
	pcomp();
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
%>
