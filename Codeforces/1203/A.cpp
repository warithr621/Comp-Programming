//walrus
//https://codeforces.com/contest/1203/problem/A

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
    vi a(n);
    forn(i, n) cin >> a[i];
    bool A = true, B = true;
    fur(i, 0, n-1) {
        if (a[i] != n && a[i] + 1 != a[i+1]) A = false;
        if (a[i] == n && a[i+1] != 1) A = false;
        if (a[i] != 1 && a[i] - 1 != a[i+1]) B = false;
        if (a[i] == 1 && a[i+1] != n) B = false;
    }
    if (A || B) cout << "YES\n";
    else cout << "NO\n";
}
 
int32_t main() {
    setIO("");
    int t = 1;
    cin >> t;
    while(t--) solve();
}