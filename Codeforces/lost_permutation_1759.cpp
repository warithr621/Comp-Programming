// https://codeforces.com/contest/1759/problem/B

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
    int n,s; cin >> n >> s;
    int mx = 0, sum = 0;
    vi a(n);
    forn(i, n) {
        cin >> a[i];
        mx = max(mx, a[i]);
        sum += a[i];
    }
    int cur = mx * (mx + 1) / 2 - sum;
    while(cur < s) cur += ++mx;
    cout << (cur == s ? "yES\n" : "No\n");
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}