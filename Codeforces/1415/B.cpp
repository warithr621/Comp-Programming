//Problem: https://codeforces.com/contest/1415/problem/B

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

void repaint(vi a, int L, int R, int x) {
    for (int i = L; i <= R; i++) a[i] = x;
}

void solve() {
    int n,k; cin >> n >> k;
    vi a(n), b(n);
    forn(i, n) {
        cin >> a[i]; b[i] = a[i];
    }
    int sum = 2e18, L = 0;
    for (int i = 1; i <= 100; i++) {
        a = b;
        int ans = 0, L = 0;
        for (int L = 0; L < n;) {
            if (a[L] == i) ++L;
            else {
                ++ans; L += k;
            }
        }
        sum = min(sum, ans);
    }
    cout << sum << '\n';
}
 
int32_t main() {
    setIO("");
    int t; cin >> t; while(t--)
    solve();
}	
