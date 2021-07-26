//Problem: 2020 February Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=1011

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
#define pb(x) push_back(x)
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
    vi x(n), y(n);
    int ans = 0;
    forn(i, n) cin >> x[i] >> y[i];
    forn(i, n) {
        forn(j, n) {
            forn(k, n) {
                if (x[i] == x[j] && y[i] == y[k]) {
                    int area = (x[k] - x[i]) * (y[i] - y[j]);
                    if (area < 0) area *= -1;
                    ans = max(ans, area);
                }
            }
        }
    }
    cout << ans << '\n';
}
 
int32_t main() {
    setIO("triangles");
    // int t; cin >> t; while(t--)
    solve();
}
