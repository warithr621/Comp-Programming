// https://codeforces.com/contest/1714/problem/C

#include <bits/stdc++.h>
using namespace std;
#define int long long
typedef vector<int> vi;
typedef map<int, int> mii;
typedef pair<int, int> pii;
#define order(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
#define mp make_pair
#define pb(x) emplace_back(x)
#define forn(i, ty) for(int i = 0; i < ty; i++)

void twice() {
    //code
    int n; cin >> n;
    int cur = 9;
    string s = "";
    while (n > 0) {
        if (n >= cur) {
            s += '0' + cur;
            n -= cur;
            --cur;
        } else {
            s += '0' + n;
            break;
        }
    }
    reverse(s.begin(), s.end());
    cout << s <<  '\n';
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) twice();
}