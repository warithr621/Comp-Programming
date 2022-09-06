// https://codeforces.com/contest/500/problem/C

%:include <bits/stdc++.h>
using namespace std;



int main() {
	int n,m; cin >> n >> m;
	vector<int> w(n+1);
	for (int i = 1; i <= n; i++) cin >> w[i];
	vector<int> b(m);
	for (int i = 0; i < m; i++) cin >> b[i];

	vector<int> st(n);
	vector<bool> vis(n+1, false);
	int cur = 0;
	for (int i = 0; i < m; i++) {
		if (!vis[b[i]]) {
			vis[b[i]] = true;
			st[cur++] = b[i];
		}
	}
	for (int i = 1; i <= n; i++) {
		if (!vis[i]) st[cur++] = i;
	}

	// for (int i : st) cout << i << '\n';


	//now just simulate I think
	int ans = 0;

	for (int i = 0; i < m; i++) {
		//trying to find b[i];
		int pos = 0, lift = 0;
		while(st[pos] != b[i]) {
			ans += w[st[pos]];
			++pos;
		}
		//b[i] is located at pos
		//now we have to actually shift the books
		for (int j = pos; j > 0; --j) st[j] = st[j-1];
		st[0] = b[i];
	}

	cout << ans << '\n';
}