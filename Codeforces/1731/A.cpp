// https://codeforces.com/contest/1731/problem/A

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
    
    int ans = 1;
    for (int x : a) ans *= x;
    ans += (n-1);
    cout << ans * 2022 << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}