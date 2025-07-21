// https://codeforces.com/contest/1454/problem/D

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
    vector<pii> pfact;
    for (int i = 2; i * i <= n; i++) {
        int cnt = 0;
        while(n % i == 0) {
            n /= i;
            ++cnt;
        }
        if (cnt != 0) pfact.push_back({cnt, i});
    }
    if (n != 0) pfact.push_back({1, n});

    sort(pfact.rbegin(), pfact.rend());
    // for (auto x : pfact) cout << x.fst << ' ' << x.sec << '\n';
    vi ans(pfact[0].fst, pfact[0].sec);
    for (int i = 1; i < pfact.size(); i++) {
        for (int j = 0; j < pfact[i].fst; ++j) {
            ans[ans.size()-1] *= pfact[i].sec;
        }
    }

    cout << ans.size() << '\n';
    for (int x : ans) cout << x << ' ';
    cout << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}