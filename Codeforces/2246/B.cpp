%:include <bits/stdc++.h>
using namespace std;
%:define int long long

void solve() <%
	//code
	int n; cin >> n;
	if (n == 1) cout << "1\n";
	else if (n == 2) cout << "-1\n";
	else {
		cout << "1 2 3 ";
		int cur = 3;
		for (int i = 4; i <= n; i++) {
			cur <<= 1;
			cout << cur << ' ';
		}
		cout << '\n';
	}
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
%>