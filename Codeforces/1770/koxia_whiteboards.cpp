// https://codeforces.com/contest/1770/problem/A

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) reverse(v.begin(), v.end())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)
#define fst first
#define sec second

void solve() <%
    //code
    int n,m; cin >> n >> m;
    vi a(n), b(m);
    forn(i, n) cin >> a[i];
    forn(i, m) cin >> b[i];

    for (int i = 0; i < m; i++) {
        int bdx = 0;
        for (int j = 0; j < n; j++) {
            if (b[i] - a[j] > b[i] - a[bdx]) {
                bdx = j;
            }
        }
        a[bdx] = b[i];
    }

    int ans = 0;
    for (int i = 0; i < n; i++) ans += a[i];
    cout << ans << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}