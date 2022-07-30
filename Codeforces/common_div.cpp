//walrus
//https://codeforces.com/contest/1203/problem/C

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

int factors(int x) {
    int ans = 0;
    for (int i = 1; i * i <= x; i++) {
        if (x % i == 0) {
            ++ans;
            if (x / i != i) ++ans;
        }
    }
    return ans;
}

void solve() {
    //code
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    int g = 0;
    forn(i, n) g = gcd(g, a[i]);
    cout << factors(g);
}
 
int32_t main() {
    setIO("");
    int t = 1;
    // cin >> t;
    while(t--) solve();
}