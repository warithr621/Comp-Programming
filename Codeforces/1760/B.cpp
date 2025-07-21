// https://codeforces.com/contest/1760/problem/B

%:include <bits/stdc++.h>
using namespace std;
// %:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() {
    //code
    int n; string s;
	cin >> n >> s;
	int ans = 1;
	for (int i = 0; i < n; i++) ans = max(ans, s[i] - 'a' + 1);
	cout << ans << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}