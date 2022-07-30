//Problem: https://codeforces.com/contest/1324/problem/D
//Note: Virtual Submission

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
    vi a(n), c(n);
    forn(i, n) cin >> a[i];
    forn(i, n) {
        int b; cin >> b;
        c[i] = a[i] - b;
    }
    s(c);
    int sum = 0;
    forn(i, n) {
        if (c[i] <= 0) continue;
        sum += c.begin() + i - lower_bound(c.begin(), c.end(), -c[i] + 1);
    }
    cout << sum << '\n';
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}	
int32_t main() {
    setIO("");
    int t; cin >> t; while(t--)
    solve();
}	