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
    int n, m; cin >> n >> m;
    int d1[m+2], d2[m+2];
    fill(d1, d1 + m + 2, 0);
    fill(d2, d2 + m + 2, 0);

    for (int i = 0; i < n; i++) {
        int l,r,p; cin >> l >> r >> p;
        d1[l] += p;
        if (r + 1 <= m) d1[r+1] -= p;
        d2[l] += p * (1 - l);
        if (r + 1 <= m) d2[r+1] -= p * (1 - l);
    }   

    int x = 0, y = 0;
    for (int i = 1; i <= m; i++) {
        x += d1[i];
        y += d2[i];
        cout << x * i + y << ' ';
    }
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
