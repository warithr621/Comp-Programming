// https://codeforces.com/contest/1454/problem/C

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) reverse(v.begin(), v.end())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() <%
    //code
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    
    vi interval(n+1, 1);
    n = unique(a.begin(), a.end()) - a.begin();
    a.resize(n);
    forn(i, n) interval[a[i]]++;
    interval[a[0]]--; interval[a[n-1]]--;

    int ans = 1e9;
    forn(i, n) ans = min(ans, interval[a[i]]);
    cout << ans << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}