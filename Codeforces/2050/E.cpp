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

void solve() <%
    //code
    string a,b,c; cin >> a >> b >> c;
    int n = a.size(), m = b.size();
    vector<vi> dp(n+1, vi(m+1, 1'000'000'000));
    dp[0][0] = 0;
    // dp[i][j] is answer for prefixes "a up to i", "b up to j", and "c up to i+j"
    // all indices inclusive me thinkies
    for (int i = 0; i < n; i++) {
    	dp[i+1][0] = dp[i][0] + (a[i] != c[i]);
    }
    for (int j = 0; j < m; j++) {
    	dp[0][j+1] = dp[0][j] + (b[j] != c[j]);
    }
    for (int i = 1; i <= n; i++) {
    	for (int j = 1; j <= m; j++) {
    		int aop = dp[i-1][j] + (a[i-1] != c[i + j - 1]);
    		int bop = dp[i][j-1] + (b[j-1] != c[i + j - 1]);
    		dp[i][j] = min(aop, bop);
    	}
    }
    // for (int i = 0; i <= n; i++) {
    // 	for (int j = 0; j <= m; j++) {
    // 		cout << dp[i][j] << ' ';
    // 	}
    // 	cout << '\n';
    // }
    cout << dp[n][m] << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
