// https://codeforces.com/contest/1778/problem/B

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() <%
    //code
    int n,m,d; cin >> n >> m >> d;
    vi p(n), a(m);
    forn(i, n) cin >> p[i];
    forn(i, m) cin >> a[i];
    
    vi pos(n+2);
    forn(i, n) {
        pos[p[i]] = i; // pos(a_i)
    }
    
    // ok so basically
    // it's bad if for all consecutive values in 'a', they differ by pos at most 'd' in 'p'
    // so we basically want there to be a case such that either two values are separated by more than d,
    // or that pos of a[i+1] is earlier than pos of a[i]
    
    
    int ans = (int)(2e10);
    
    forn(i, m-1) {
        // focusing on how we can fix a[i] and a[i+1];
        if (pos[a[i+1]] < pos[a[i]]) ans = 0;// i+1 is left
        else if (pos[a[i+1]] - pos[a[i]] > d) ans = 0;// separated by more than d
        else {
            int p1 = pos[a[i+1]] - pos[a[i]]; // move i+1 left
            int p2 = d+1 - (pos[a[i+1]] - pos[a[i]]); // move i+1 too far right
            // wait gotta test smth
            if (d + 1 >= n) p2 = (int)(2e10);
            // cout << p1 << ' ' << p2 << '\n';
            ans = min(ans, min(p1, p2));
        }
        // cout << "TMP" << ans << '\n';
    }
    
    cout << ans << '\n';
    
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}