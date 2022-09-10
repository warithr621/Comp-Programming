// https://codeforces.com/contest/856/problem/A

#include <bits/stdc++.h>
#define int long long
using namespace std;

bool vis[2000005];

void solve() {
	int n; cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	sort(a.begin(), a.end());
	memset(vis, false, 2000005); //oops forgot to change the memset

	cout << "YES\n"; //ans always exists
	int apd = 1;
	for (int i = 0; i < n; i++) { //wait I'm bad with bounds
		cout << apd << ' ';
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				//set future values as sucky
				int v = apd + a[j] - a[k];
				if (v >= 1 && v <= 2000005) vis[v] = true;
			}
		}
		while(vis[apd]) ++apd;
	}
	cout << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);

	int T; cin >> T;
	while(T--) solve();
}