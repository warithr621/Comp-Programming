// https://codeforces.com/contest/1759/problem/A

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)
 
void solve() {
    //code
    string s; cin >> s;
    if (s[0] != 'Y' && s[0] != 'e' && s[0] != 's') {
        cout << "NO\n";
        return;
    }
 
    string test= "Yes";
    for (int i = 1; i < s.size(); i++) {
        int j = 0;
        for (; j < 3; ++j) if (test[j] == s[i-1]) break;
        j = (j+1)%3;
        if (s[i] != test[j]) {
            cout << "NO\n"; return;
        }
    }
    cout << "YES\n";
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}