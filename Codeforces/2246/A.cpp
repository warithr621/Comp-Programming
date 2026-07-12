%:include <bits/stdc++.h>
using namespace std;

void solve() <%
	//code
	int n; cin >> n;
	for (int i = 2; i <= n; i += 2) {
		cout << i << ' ' << i-1 << ' ';
	}
	cout << '\n';
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
%>