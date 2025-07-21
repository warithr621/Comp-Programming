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
    string s; cin >> s;
    vector<char> v;
    for (char c : s) v.pb(c);
    for (int i = 1; i < v.size(); i++) {
    	int ptr = i;
    	while (ptr != 0 && v[ptr] != '0') {
    		if (v[ptr] - 1 > v[ptr-1]) {
    			v[ptr]--;
    			swap(v[ptr], v[ptr-1]);
    			--ptr;
    		} else {
    			break;
    		}
    	}
    }
    for (char c : v) cout << c;
    cout << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
