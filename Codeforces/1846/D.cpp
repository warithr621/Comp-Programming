// https://codeforces.com/contest/1846/problem/D

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
 
void solve() <%
    //code
    int n, d, h; cin >> n >> d >> h;
    int y[n];
    for (int i = 0; i < n; i++) cin >> y[i];
    double ans = 0;
    
    // work bottom to top and use triangle or trapezoid
    for (int i = 0; i < n; i++) {
        // find if it intersects
        if (i != n-1 and y[i] + h > y[i+1]) {
            // trapezoid
            // big base = d
            // small base = d * (h - (y[i+1] - y[i])) / h?? [ok nvm this is wrong lol]
            ans += 0.5 * (y[i+1] - y[i]) * (d + 1.0 * d * (h - (y[i+1] - y[i])) / h);
        } else {
            // triangle
            ans += 0.5 * d * h;
        }
    }
    
    cout << setprecision(8) << ans << '\n';
%>

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T --> 0) solve();
}