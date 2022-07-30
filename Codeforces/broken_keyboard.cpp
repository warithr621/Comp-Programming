//Problem: https://codeforces.com/problemset/problem/1251/A

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double;
typedef vector<int> vi;
typedef map<int, int> mii;
typedef pair<int, int> pii;
#define s(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
#define bs(v, s) binary_search(v.begin(), v.end(), s)
#define minvec(v) *min_element(v.begin(), v.end())
#define maxvec(v) *max_element(v.begin(), v.end())
#define mp make_pair
#define pb(x) push_back(x)
#define fst first
#define sec second
#define foru(i, n, ty, x) for (int i = n; i < ty; i += x)
#define ford(i, n, ty, x) for (int i = n; i >= ty; i -= x)
#define forn(i, ty) foru(i, 0, ty, 1)

void setIO(string name) {
	cin.tie(0)->sync_with_stdio(0);
	if (name != "") {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}

void solve() {
    string s; cin >> s;
    vi a(26, 0);
    char cur = s[0];
    int T = 1;
    for(int i = 1; i < s.size(); i++) {
        if (s[i] == cur) ++T;
        else {
            if (T % 2 == 1) a[cur - 'a'] = 1;
            cur = s[i];
            T = 1;
        }
    }
    if (T % 2 == 1) a[cur - 'a'] = 1;
    forn(i, 26) {
        if (a[i] == 1) cout << (char) (i + 'a');
    }
    cout << '\n';
}
 
int32_t main() {
    setIO("");
    int t; cin >> t; while(t--)
    solve();
}	
