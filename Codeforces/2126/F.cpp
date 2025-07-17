%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())

// wow what if I fenwick this, this is lowk terrible
struct Fenwick {
	int n;
	vector<int> f;
	Fenwick(int _n): n(_n), f(n+1, 0) {}

	void add(int i, int x) {
		for (; i <= n; i += i & -i) {
			f[i] += x;
		}
	}
	int sum(int i) const {
		int s = 0;
		for (; i > 0; i -= i & -i) {
			s += f[i];
		}
		return s;
	}

	int sum(int l, int r) const {
		return sum(r) - sum(l - 1);
	}

};

// wow the freaking fenwick TLEs, what if i do hld bs :skull:
// im literally making this up on the spot istg this wont work
// upd: it did

void solve() <%
    //code (wow this is some of the most tragic code ive written)
	int n,q; cin >> n >> q;
	vector<int> a(n+1);
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}
	vector<vector<pii>> adj(n+1);
	int cost = 0;
	for (int i = 1; i < n; i++) {
		int u, v, c; cin >> u >> v >> c;
		adj[u].push_back({v, c});
		adj[v].push_back({u, c});
		if (a[u] != a[v]) cost += c;
	}

	int B = max(1LL, (int) sqrt(2*(n-1)));
	vector<bool> heavy(n+1, false);
	for (int i = 1; i <= n; i++) {
		if ((int) adj[i].size() > B) heavy[i] = true;
	}

	vector<unordered_map<int, int>> hc(n+1);
	vector<vector<pii>> hnbr(n+1);
	for (int i = 1; i <= n; i++) {
		if (heavy[i]) {
			auto &m = hc[i];
			for (auto [u, c] : adj[i]) {
				m[a[u]] += c;
			}
		}
		for (auto [u, c] : adj[i]) {
			if (heavy[u]) {
				hnbr[i].push_back({u, c});
			}
		}
	}

	while (q --> 0) {
		int v, x; cin >> v >> x;
		int old = a[v];
		if (heavy[v]) {
			cost += hc[v][old] - hc[v][x];
		} else {
			for (auto [u, c] : adj[v]) {
				if (a[u] != old) cost -= c;
				if (a[u] != x) cost += c;
			}
		}
		for (auto [u, c] : hnbr[v]) {
			hc[u][old] -= c;
			hc[u][x] += c;
		}
		a[v] = x;
		cout << cost << '\n';
	}
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
%>
