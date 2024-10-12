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

bool works(vi eggs, int k, int dist) {
    int lamps = 0, pos = -(1e9);
    for (int x : eggs) {
        if (x > pos + dist) {
            ++lamps;
            pos = x + dist;
            if (lamps > k) return false;
        }
    }
    return true;
}

void solve() <%
    //code
    int n, k; cin >> n >> k;
    vi a(n);
    for (int &i : a) cin >> i;
    order(a);
    int L = 0, R = a[n-1] - a[0];
    while (L < R) {
        int M = (L + R) / 2;
        if (works(a, k, M)) R = M;
        else L = ++M;
    }
    cout << L << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
