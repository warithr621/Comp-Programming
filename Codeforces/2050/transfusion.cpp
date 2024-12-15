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
    int a[n];
    for (int &x : a) {
    	cin >> x;
    }
    int o = 0, e = 0, oc = 0, ec = 0;
    for (int i = 0; i < n; i++) {
    	if (i % 2 == 0) {
    		ec++;
    		e += a[i];
    	} else {
    		oc++;
    		o += a[i];
    	}
    }
    cout << (e % ec == 0 and o % oc == 0 and e / ec == o / oc ? "YES\n" : "NO\n");
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
