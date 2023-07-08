// https://codeforces.com/contest/1846/problem/A

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
 
void solve() <%
    //code
    int n; cin >> n;
    int ans = 0;
    while(n--) {
        int a,b; cin >> a >> b;
        ans += (a > b);
    }
    cout << ans << '\n';
%>

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T --> 0) solve();
}