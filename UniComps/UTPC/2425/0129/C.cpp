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
    int n, k; cin >> n >> k;
    int h[n];
    for (int i = 0; i < n; i++) cin >> h[i];
    int ans = 1, cnt = 1;
    for (int i = 0; i + 1 < n; i++) {
        if (abs(h[i] - h[i+1]) <= k) {
            ++cnt;
        } else {
            ans = max(ans, cnt);
            cnt = 1;
        }
    }
    cout << max(ans, cnt) << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
