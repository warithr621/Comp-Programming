// CSES Creating Strings

#include <bits/stdc++.h>
#include <unordered_map>
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
 
int fact(int x) {
    if (x <= 1) return 1;
    return x * fact(x - 1);
}
 
void solve() {
    string s; cin >> s;
    char c[s.length()];
    vi a(26, 0);
    int ans = fact(s.length());
    forn(i, s.length()) a[s[i] - 'a']++;
    forn(i, 26) ans /= fact(a[i]);
    cout << ans << '\n';
    forn(i, s.length()) c[i] = s[i];
    sort(c, c + s.length());
    do {
        forn(i, s.length()) cout << c[i];
        cout << '\n';
    } while(next_permutation(c, c + s.length()));
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}