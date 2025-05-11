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

pair<int, int> troll(int n) {
	if (n == 4) return {1,0};
	if (n == 5) return {1,1};
	if (n == 8) return {2,1};
	if (n == 9) return {2,2};
	if (n == 12) return {3,2};
	if (n == 13) return {3,3};
	if (n == 16) return {4,3};
	if (n == 20) return {5,3};
	if (n == 21) return {5,4};
	if (n == 24) return {6,4};
	if (n == 25) return {6,5};
	if (n == 28) return {7,5};
	if (n > 28) {
		auto p = troll(n - 28);
		if (p.first == -1) return {-1,-1};
		return {7 + p.first, 5 + p.second};
	}
	return {-1, -1};
}

void solve() <%
    //code
    int n; cin >> n;
    auto p = troll(n);
    if (p.first == -1) cout << "-1\n";
    else cout << p.first << ' ' << p.second << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>