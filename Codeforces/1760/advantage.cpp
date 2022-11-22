// https://codeforces.com/contest/1760/problem/C

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
	vi a(n), b(n);
	forn(i, n) {cin >> a[i]; b[i] = a[i];}
	sort(b.rbegin(), b.rend());

	forn(i, n) cout << a[i] - (a[i] == b[0] ? b[1] : b[0]) << ' ';
	cout << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}