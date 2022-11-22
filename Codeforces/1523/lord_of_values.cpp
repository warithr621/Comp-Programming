//Problem: https://codeforces.com/contest/1523/problem/B

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
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    cout << 3*n << '\n';
    for (int i = 1; i <= n; i += 2) {
        forn(j, 3) cout << "1 " << i << ' ' << i+1 << '\n' << "2 " << i << ' ' << i+1 << '\n';
    }
}
 
int32_t main() {
    setIO("");
    int t; cin >> t; while(t--)
    solve();
}	
