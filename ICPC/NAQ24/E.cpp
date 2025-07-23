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
    int N; cin >> N;
    vector<int> f(51, 0);
    for (int i = 0; i < 50 * N; i++) {
        int X; cin >> X;
        f[X]++;
    }
    bool p = false;
    for (int i = 1; i <= 50; i++) {
        if (f[i] > 2 * N) {
            cout << i << ' ';
            p = true;
        }
    }
    if (p == false) cout << "-1\n";
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
