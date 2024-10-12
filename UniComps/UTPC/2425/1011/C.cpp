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
    string s; cin >> s;
    int f[26];
    for (int i = 0; i < 26; i++) f[i] = 0;
    for (char c : s) f[c - 'a']++;
    for (int i = 0; i < 26; i++) {
		for (int i = 0; i < f[i]/2; i++) {
			cout << (char) ('a' + i) << ' ';
		}
    }
    for (int i = 0; i < 26; i++) {
    	if (f[i] % 2 == 1) {
    		cout << (char) ('a' + i) << ' ';
    	}
    }
    for (int i = 0; i < 26; i++) {
		for (int i = 0; i < f[i]/2; i++) {
			cout << (char) ('a' + i) << ' ';
		}
    }
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
