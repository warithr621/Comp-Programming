// https://codeforces.com/contest/1772/problem/D

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) reverse(v.begin(), v.end())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

bool sorted(vi a) {
    bool b = true;
    for (int i = 1; i < (int) a.size(); ++i) {
        b &= a[i] >= a[i-1];
    }
    return b;
}

void solve() <%
    //code
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];

    // check off some subtasks first
    // if (sorted(a)) {
    //     cout << "0\n";
    //     return;
    // }
    // rev(a);
    // if (sorted(a)) {
    //     cout << "200000000\n";
    //     return;
    // }
    
    // rev(a);

    // try testing intermediate medians?
    // if L < R, then x <= floor of median
    // if L > R, then x >= ceil of median
    // then just unionize all the intervals and see if an 'x' exists

    int mn = 0, mx = (int) 1e9;
    for (int i = 1; i < n; i++) {
        int L = a[i-1], R = a[i];
        if (L < R) {
            mx = min(mx, (L + R) / 2);
        }
        if (L > R) {
            mn = max(mn, (L + R + 1) / 2);
        }
    }

    cout << (mn <= mx ? (mn + mx) / 2 : -1) << '\n';
    // ngl there's no reason for the (mn+mx)/2 vs just mn other than being funny
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}