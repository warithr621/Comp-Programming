// https://codeforces.com/contest/1846/problem/B

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
 
void solve() <%
    //code
    string a[3];
    for (int i = 0; i < 3; i++) cin >> a[i];
    
    string ans = "DRAW";
    for (int i = 0; i < 3; i++) {
        if (a[i][0] == a[i][1] and a[i][1] == a[i][2] and a[i][0] != '.') ans = a[i][0];
    }
    for (int j = 0; j < 3; j++) {
        if (a[0][j] == a[1][j] and a[1][j] == a[2][j] and a[0][j] != '.') ans = a[0][j];
    }
    if (a[0][0] == a[1][1] and a[1][1] == a[2][2] and a[0][0] != '.') ans = a[0][0];
    if (a[2][0] == a[1][1] and a[1][1] == a[0][2] and a[2][0] != '.') ans = a[2][0];
    
    cout << ans << '\n';
%>

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T --> 0) solve();
}