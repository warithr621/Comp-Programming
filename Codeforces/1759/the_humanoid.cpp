// https://codeforces.com/contest/1759/problem/E

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

int ans = 0, n, h, a[200005];
 
void dfs(int pos, int g, int b, int pwr) {
    if (pos == n) return;
    if (pwr > a[pos]) {
        pwr += a[pos] / 2;
        ans = max(ans, ++pos);
        dfs(pos, g, b, pwr);
    } else {
        if (g != 0) dfs(pos, g-1, b, pwr*2);
        if (b != 0) dfs(pos, g, b-1, pwr*3);
    }
}

void solve() {
    //code
    cin >> n >> h;
    ans = 0;
    forn(i, n) cin >> a[i];
    sort(a, a+n);
    dfs(0, 2, 1, h);
    cout << ans << '\n';
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}