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
    int sum = 0;
    vi cnt = {0, 0}; // # of 2s and 3s
    for (char c : s) {
    	sum += (c - '0');
    	if (c == '2') ++cnt[0];
    	else if (c == '3') ++cnt[1];
    }
    // if (sum % 9 == 0) {
    // 	cout << "YES\n";
    // 	return;
    // }
    // 2 turns into 4, adding 2 to the sum
    // 3 turns into 9, adding 6 to the sum
    // if sum + 2x + 6y is divisible by 9, where x <= 2cnt and y <= 3cnt, we good
    for (int i = 0; i <= cnt[0]; i++) {
    	for (int j = 0; j <= cnt[1]; j++) {
    		if ((sum + 2 * i + 6 * j) % 9 == 0) {
    			cout << "YES\n";
    			return;
    		}
    	}
    }
    cout << "NO\n";
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while (T --> 0) solve();
%>
