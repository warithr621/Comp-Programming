%:include <bits/stdc++.h>
using namespace std;
%:define int long long

const int MOD = 1e9 + 7;
const int MAXN = 200000;
int pw2[MAXN + 1];

void solve() <%
	//code
	int n; cin >> n;
	vector<int> a(n);
	for (int &x : a) {
		cin >> x;
	}
	// this should just be dp ?? hm apparently not exactly idk
	// wait so basically it's like
		// [odd number of -1s]
		// [pairs of i,j where i = j] <-- could be zero such pairs
		// [i then i+1]
	// or
		// [even number of -1s]
		// [pairs of i,j where i = j] <-- could be zero such pairs
		// note that [] is valid
	int m = 0;
	while (m < n && a[m] == -1) ++m; // number of -1s
	vector<int> distinct;
	int i = m;
	while (i < n) {
		int v = a[i];
		distinct.push_back(v);
		while (i < n && a[i] == v) ++i;
	}
	int sz = distinct.size();
	int ans = pw2[n - (sz + (m > 0 ? 1 : 0))];
	// ^^ is cause like smth smth prod of all 2^(i-1) is 2^(n - # blocks)
	int cnt = 1;
	if (m > 0) {
		for (int k = 1; k < sz; k++) {
			if (distinct[k] == distinct[k-1] + 1) {
				cnt++;
			}
		}
	}
	ans = (ans * cnt) % MOD;
	cout << ans << '\n';
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	pw2[0] = 1;
	for (int i = 1; i <= MAXN; i++) {
		pw2[i] = (pw2[i-1] << 1) % MOD;
	}
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
%>