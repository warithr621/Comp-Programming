/*
Im Nayeon
Yoo Jeongyeon
Momo Jjang
Sana Jjang
Park Jihyo
Mina Jjang
Kim Dahyun
Son Chaeyoung
Chou Tzuyu
One in a million
눈부시게 사랑해
트와이스 !!
*/

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())
%:define pb(x) push_back(x)
%:define forn(i, n) for(int i = 0; i < n; ++i)

double update(double cur, double next) {
    if (next < 0) return cur;
    return min(cur, next);
}

void solve() <%
    //code
    int N; cin >> N;
    double farthest = 10000000;
    while (N --> 0) {
        double a, b, c, d; 
        cin >> a >> b >> c >> d;
        // find slope between (a,b) and (c,d)
        if (a == c) {
            // vertical line, so never matters
            continue;
        }
        double m = (d - b) / (c - a);
        // point-slope form: y - b = m(x - a)
        // solve for x = 0
        double yint = m * (-a) + b;
        // yint has to be in the range of the boundary
        if (min(a,c) < 0 && max(a,c) > 0) {
            farthest = update(farthest, yint);
        }
    }
    if (farthest == 10000000) cout << "-1\n";
    else cout << setprecision(7) << farthest;
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>


