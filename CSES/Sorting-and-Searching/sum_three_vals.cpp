// CSES Sum of Three Values

#include <bits/stdc++.h>
using namespace std;
// #define int long long
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
    int n,x; cin >> n >> x;
    pii a[n];
    forn(i, n) {
        cin >> a[i].fst;
        a[i].sec = i + 1;
    }
    sort(a, a+n);
    forn(i, n) {
        for (int j = i+1; j < n && a[i].fst + a[j].fst < x; j++) {
            int k = lower_bound(a, a+n, mp(x - a[i].fst - a[j].fst, 0)) - a;
            while(i == k || j == k) ++k;
            if (k != n && a[i].fst + a[j].fst + a[k].fst == x) {
                cout << a[i].sec << ' ' << a[j].sec << ' ' << a[k].sec << '\n';
                return;
            }
        }
    }
    cout << "IMPOSSIBLE\n";
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}