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
    int n,w,b; cin >> n >> w >> b;
    if (w == 0 && b == 0) {
    	cout << (n == 0 ? 1 : 0) << '\n';
    	return;
    } else if (w == 0) {
    	cout << (n % b == 0 ? 1 : 0) << '\n';
    	return;
    } else if (b == 0) {
    	cout << (n % w == 0 ? 1 : 0) << '\n';
    	return;
    }
    int ans = 0;
    for (int white = 0; white <= n; white++) {
    	if (white % w != 0) continue;
    	int black = n - white;
    	if (black % b != 0) continue;
    	ans++;
    }
    cout << ans << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>