//Problem: https://codeforces.com/contest/1557/problem/A
//Note: In-Contest Submission

#include <bits/stdc++.h>
using namespace std;
#define int long long
// #define double long double;
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

double div(double x, double y) {
    if (y != 0) return x/y;
    return -10000000000;
}

void solve() {
    int n; cin >> n;
    vector<double> a(n);
    forn(i, n) cin >> a[i];
    double x = 0, xs = 0, y = 0, xy = 0;
    rev(a);
    forn(i, n) {
        if (i == 0) {
            x += a[i]; ++xs;
            continue;
        }
        if (div(x + a[i], xs+1) + div(y, xy) > div(x, xs) + div(y, xy)) {
            x += a[i]; ++xs;
        } else {
            y += a[i]; ++xy;
        }
    }
    double ans = x/xs + y/xy;
    cout << setprecision(15) << ans << '\n';
}
 
int32_t main() {
    setIO("");
    int t; cin >> t; while(t--)
    solve();
}	
