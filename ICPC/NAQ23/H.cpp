// 2023 NAQ: Magnesium Supplementation

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
%:define forn(i, n) for(int i = 0; i < n; ++i)

void solve() <%
    //code
    int N, K, P; cin >> N >> K >> P;
    // you need to make exactly 'N', using no more than 'P' pills, and each being at most 'K'
    vector<int> ans;
    for (int i = 1; i * i <= N; i++) {
    	if (N % i != 0) continue;
    	if (i <= K && N/i <= P) ans.pb(i);
    	if (i * i != N && N/i <= K && i <= P) ans.pb(N / i);
    }
    order(ans);
    cout << ans.size() << '\n';
    for (int x : ans) cout << x << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
