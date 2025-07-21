// https://codeforces.com/contest/1772/problem/B

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

int a[2][2];

bool yay() {
    return a[0][0] < a[0][1] and a[1][0] < a[1][1] and a[0][0] < a[1][0] and a[0][1] < a[1][1];
}

void rot() {
    int w = a[0][0], x = a[0][1], y = a[1][0], z = a[1][1];
    a[0][0] = y;
    a[0][1] = w;
    a[1][0] = z;
    a[1][1] = x;
}

void solve() <%
    //code
    cin >> a[0][0] >> a[0][1] >> a[1][0] >> a[1][1];

    bool b = false;
    for (int i = 0; i < 4; i++) {
        // cout << a[0][0] << ' ' << a[0][1] << ' ' << a[1][0] << ' ' << a[1][1] << '\n';
        b |= yay();
        rot();
    }

    cout << (b ? "YES\n" : "NO\n");
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}