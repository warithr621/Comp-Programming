// https://codeforces.com/contest/1778/problem/A

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() <%
    //code
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    
    int s = 0;
    forn(i, n) s += a[i];
    
    forn(i, n-1) {
        if (a[i] == -1 && a[i+1] == -1) {
            cout << s + 4 << '\n';
            return;
        }
    }
    forn(i, n-1) {
        if (a[i] != a[i+1]) {
            cout << s << '\n';
            return;
        }
    }
    cout << s - 4 << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}