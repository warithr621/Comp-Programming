// https://codeforces.com/contest/1772/problem/C

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

vi make(int x, int sz) {
    vi ret = {};
    for (int i = 0; i < sz; i++) {
        ret.pb(i < x-1 ? i+2 : 1);
    }
    return ret;
}

int sum(vi a) {
    int ret = 0;
    for (int x : a) ret += x;
    return ret;
}

void solve() <%
    //code
    int k,n; cin >> k >> n;
    int cur = 1;
    for (int i = 1; i < k; ++i) {
        vi test = make(i, k-1);
        if (sum(test) <= n-1) {
            cur = i;
        }
    }

    vi ans = {1};
    vi test = make(cur, k-1);
    for (int x : test) {
        ans.pb(ans[ans.size() - 1] + x);
    }

    for (int x : ans) cout << x << ' ';
    cout << '\n';
%>
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}