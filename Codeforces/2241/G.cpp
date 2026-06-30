%:include <bits/stdc++.h>
using namespace std;
%:define int long long

void solve() <%
	//code
	int n; cin >> n;
	vector<int> a(n);
	for (int &x : a) {
		cin >> x;
	}
	map<int, int> lefts;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		int contribution = 0;
		for (auto it = lefts.begin(); it != lefts.end();) {
			int v = it->first, cnt = it->second;
			int mod = a[i] % v;
			int d = min(mod, v - mod);
			if (d > 0) {
				contribution += d * (n - i) * cnt;
				it = lefts.erase(it);
			} else {
				++it;
			}
		}
		ans += contribution;
		lefts[a[i]]++;
	}
	cout << ans << '\n';
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
%>
