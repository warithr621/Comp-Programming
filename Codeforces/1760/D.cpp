// https://codeforces.com/contest/1760/problem/D

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() {
    //code
    int n; cin >> n;
	vi a(n);
	forn(i, n) cin >> a[i];

	bool yay = false;
	for (int i = 1; i < n; i++) {
		if (yay && a[i] < a[i-1]) {
			cout << "NO\n";
			return;
		}
		if (a[i] > a[i-1]) yay = true;
	}

	cout << "YES\n";
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}