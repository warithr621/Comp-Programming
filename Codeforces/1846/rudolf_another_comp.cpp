// https://codeforces.com/contest/1846/problem/C

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
 
void solve() <%
    //code
    int n, m, h; cin >> n >> m >> h;
    // note rudolf is first person
    int a[m];
    for (int i = 0; i < m; i++) cin >> a[i];
    sort(a, a + m);
    
    int rs = 0, rp = 0;
    int t = 0;
    for (int i = 0; i < m; i++) {
        if (t + a[i] <= h) {
            t += a[i];
            ++rs;
            rp += t;
        } else break;
    }
    
    int ans = 1;
    // find # of people that beat him
    for (int i = 1; i < n; i++) {
        for (int i = 0; i < m; i++) cin >> a[i];
        sort(a, a + m);
        
        int ps = 0, pp = 0;
        int t = 0;
        for (int i = 0; i < m; i++) {
            if (t + a[i] <= h) {
                t += a[i];
                ++ps;
                pp += t;
            } else break;
        }
        
        if (!(rs > ps or (rs == ps and rp <= pp))) ++ans;
    }
    
    cout << ans << '\n';
%>

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T --> 0) solve();
}