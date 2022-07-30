//Problem: https://codeforces.com/problemset/problem/459/B

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

bool aut(int L, int R, int i) {
    if (L > R && L > (10 - i + 2) / 2 + R) return true;
    if (R > L && R > (10 - i + 1) / 2 + L) return true;
    return false;
}

void solve() {
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    s(a);
    cout << a[n-1] - a[0] << ' ';
    int L = 0, R = n-1;
    while(a[L+1] == a[L] && L < n) ++L;
    while(a[R-1] == a[R] && R >= 0) --R;
    cout << (a[0] == a[n-1] ? n * (n-1) / 2 : (++L) * (n - R)) << '\n';
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}	
