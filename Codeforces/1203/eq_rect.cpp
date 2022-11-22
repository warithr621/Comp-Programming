//walrus
//https://codeforces.com/contest/1203/problem/B

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
#define fur(i, n, ty) for (int i = n; i < ty; i++)
#define forn(i, ty) fur(i, 0, ty)

void setIO(string name) {
	cin.tie(0)->sync_with_stdio(0);
	if (name != "") {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}

void solve() {
    //code
    int n; cin >> n;
    vi a(4*n);
    forn(i, 4*n) cin >> a[i];
    s(a);
    int area = a[0] * a[4*n-1];
    forn(i, n) {
        int L = i*2, R = 4 * n - i * 2 - 1;
        if (a[L] != a[L+1] || a[R] != a[R-1] || a[L] * a[R] != area) {
            cout << "NO\n";
            return;
        }
    }
    cout << "YES\n";
}
 
int32_t main() {
    setIO("");
    int t = 1;
    cin >> t;
    while(t--) solve();
}