// kuroni is genuinely anti-py wtf is this stupid ass aaaa

%:include <bits/stdc++.h>
using namespace std;
using i64 = long long;

void solve() <%
	//code
	int n, q; cin >> n >> q;
	vector<i64> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	if (n == 0) {
		for (int i = 0; i < q; i++) {
			string s; cin >> s;
			cout << s << '\n';
		}
		return;
	}
	vector<i64> att(n);
	att[0] = a[0] - 1;
	for (int i = 1; i < n; i++) {
		att[i] = att[i-1] + (a[i] - a[i-1] - 1);
	}
	for (int i = 0; i < q; i++) {
		i64 k; cin >> k;
		auto itr = lower_bound(att.begin(), att.end(), k);
		int idx = int(itr - att.begin()) - 1;
		if (idx == -1) cout << k << '\n';
		else cout << a[idx] + (k - att[idx]) << '\n';
	}
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T --> 0) solve();
%>
