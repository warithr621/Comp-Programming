// https://codeforces.com/contest/1454/problem/B

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
    int n; cin >> n;
    vector<pii> a(n);
    forn(i, n) {
        int x; cin >> x;
        a[i] = {x, i+1};
    }
    order(a);
    
    if (n == 1) {
        // edge
        cout << "1\n";
        return;
    }

    if (a[0].fst < a[1].fst) {
        cout << a[0].sec << '\n';
        return;
    }

    for (int i = 1; i < n-1; ++i) {
        if (a[i].fst != a[i-1].fst and a[i].fst != a[i+1].fst) {
            cout << a[i].sec << '\n';
            return;
        }
    }

    if (a[n-1].fst != a[n-2].fst) {
        cout << a[n-1].sec << '\n';
    } else cout << "-1\n";
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}