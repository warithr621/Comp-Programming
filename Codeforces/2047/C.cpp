// https://codeforces.com/contest/2047/problem/C

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
    int n; cin >> n;
    int a[2][n];
    for (int i = 0; i < n; i++) cin >> a[0][i];
    for (int i = 0; i < n; i++) cin >> a[1][i];
    int ans = -1'000'000'000;
    for (int i = 0; i < n; i++) {
        // let this be the column we go down on
        int tmp = a[0][i] + a[1][i];
        for (int j = 0; j < n; j++) {
            if (j == i) continue;
            tmp += max(a[0][j], a[1][j]);
        }
        ans = max(ans, tmp);
    }
    cout << ans << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
