//Problem: https://codeforces.com/problemset/problem/1360/D

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
    int n,k,ans=1e18; cin >> n >> k;
    for (int i = 1; i <= sqrt(n); i++) {
        if (n % i == 0) {
            if (i <= k) ans = min(ans, n/i);
            if (n / i <= k) ans = min(ans, i);
        }
    }
    cout << ans << '\n';
}
 
int32_t main() {
    setIO("");
    int t; cin >> t; while(t--)
    solve();
}	
