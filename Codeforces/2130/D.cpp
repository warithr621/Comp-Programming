%:include <bits/stdc++.h>
using namespace std;
%:define int long long

struct Fenwick {
	int n;
	vector<int> fw;
	Fenwick(int _n=0): n(_n), fw(n+1, 0) {}
	void init(int _n) {
		n = _n;
		fw.assign(n + 1, 0);
	}
	void update(int i) {
		for (; i <= n; i += (i & -i)) {
			fw[i]++;
		}
	}
	int query(int i) {
		int s = 0;
		for (; i > 0; i -= (i & -i)) {
			s += fw[i];
		}
		return s;
	}
};

void solve() <%
    //code
    int n; cin >> n;
    vector<int> p(n+1);
    for (int i = 1; i <= n; i++) cin >> p[i];
    vector<int> pfx(n+1), sfx(n+1);
	Fenwick fw(n);
	int invp = 0;
	fw.init(n);
	for (int i = n; i >= 1; i--) {
		pfx[i] = fw.query(p[i] - 1);
		invp += pfx[i];
		fw.update(p[i]);
	}
	fw.init(n);
	for (int i = 1; i <= n; i++) {
		sfx[i] = (i-1) - fw.query(p[i]);
		fw.update(p[i]);
	}
	int ans = invp;
	for (int i = 1; i <= n; i++) {
		int d = (n-i) - pfx[i] - sfx[i];
		if (d < 0) ans += d;
	}
	cout << ans << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
