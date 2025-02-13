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
    int n, m;
    cin >> n >> m;
    vector<int> l(n), h(n), a(m), w(m);
    for (int i = 0; i < n; i++) cin >> l[i] >> h[i];
    for (int i = 0; i < m; i++) cin >> a[i] >> w[i];

    vector<pair<int, int>> jetstreams(m);
    for (int i = 0; i < m; i++) jetstreams[i] = {a[i], w[i]};
    sort(jetstreams.begin(), jetstreams.end());

    vector<int> pfxw(m + 1, 0);
    for (int i = 0; i < m; i++) {
        pfxw[i + 1] = pfxw[i] + jetstreams[i].second;
    }

    // i forgot how lower bound and upper bound work
    for (int finch = 0; finch < n; finch++) {
        int height = h[finch];
        int L = 0, R = m - 1;
        int last = -1;
        while (L <= R) {
            int M = (L + R) >> 1;
            if (jetstreams[M].first < height) {
                last = M;
                L = ++M;
            } else {
                R = --M;
            }
        }

        L = 0; R = m - 1;
        int first = -1;
        while (L <= R) {
            int M = (L + R) >> 1;
            if (jetstreams[M].first == height) {
                first = M;
                R = --M;
            } else if (jetstreams[M].first < height) {
                L = ++M;;
            } else {
                R = --M;
            }
        }

        int wind = 0;
        if (last != -1) {
            wind += 2 * pfxw[last + 1];
        }

        if (first != -1) {
            int last = first;
            while (last + 1 < m && jetstreams[last + 1].first == height) {
                last++;
            }
            wind += (pfxw[last + 1] - pfxw[first]);
        }

        l[finch] += wind;
    }

    for (int x : l) cout << x << ' ';
    cout << endl;
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>