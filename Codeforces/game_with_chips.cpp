// https://codeforces.com/contest/1327/problem/C

%:include <bits/stdc++.h>
#define int long long
using namespace std;

signed main() <%
	int n,m,k; cin >> n >> m >> k;
	vector<pair<int, int>> s(k), f(k);
	for (int i = 0; i < k; i++) {
		int x,y; cin >> x >> y;
		s[i] = {x, y};
	}
	for (int i = 0; i < k; i++) {
		int x,y; cin >> x >> y;
		f[i] = {x, y};
	}

	string ans = "";
	/*
	first, assume we have a chip in the bottom right
	we should move this up and to the left
	becaue of the wall property, all other chips will reach the pt
	*/

	for (int i = 1; i < n; i++) ans += "U";
	for (int i = 1; i < m; i++) ans += "L";

	//now just move all the way right, down, all left, down, etc.
	for (int i = 0; i < n; i++) {
		if (i != 0) ans += "D";
		for (int j = 1; j < m; j++) ans += (i % 2 == 0 ? "R" : "L");
	}

	cout << ans.length() << '\n' << ans << '\n';
%>