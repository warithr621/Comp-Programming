%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())
%:define pb(x) push_back(x)

void solve() <%
    //code
    int n; cin >> n;
    vector<array<int, 3>> ans;
    ans.push_back({1, 1, n});
    for (int i = 2; i <= n; i++) {
    	ans.push_back({i, 1, i-1});
    	ans.push_back({i, i, n});
    }
    cout << ans.size() << '\n';
    for (auto a : ans) {
    	cout << a[0] << ' ' << a[1] << ' ' << a[2] << '\n';
    }
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
