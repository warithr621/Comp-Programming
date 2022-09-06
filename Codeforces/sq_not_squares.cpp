// https://codeforces.com/contest/898/problem/E

%:include <bits/stdc++.h>
#define int long long
#define pb push_back
using namespace std;

bool sq(int x) {
	int tmp = sqrt(x);
	return tmp * tmp == x;
}

signed main() <%
	int n; cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];

	vector<vector<int>> par(2, vector<int>());
	for (int x : a) {
		if (sq(x)) {
			if (x == 0) par[0].pb(2);
			else par[0].pb(1);
		} else {
			int low = sqrt(x), high = low+1;
			par[1].pb(min(x - low*low, high*high - x));
		}
	}
	
	sort(par[0].begin(), par[0].end());
	sort(par[1].begin(), par[1].end());

	if (par[0].size() == par[1].size()) cout << "0\n";
	else {
		int idx = (par[0].size() < par[1].size());
		int diff = abs((int) par[0].size() - (int) par[1].size()) / 2;
		int ans = 0;

		for (int i = 0; i < diff; i++) ans += par[idx][i];
		cout << ans << '\n';
	}
%>