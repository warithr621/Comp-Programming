//Problem: 2021 January Bronze P2 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=1084

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double;
typedef vector<int> vi;
#define s(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
#define bs(v, s) binary_search(v.begin(), v.end(), s)
#define minvec(v) *min_element(v.begin(), v.end())
#define maxvec(v) *max_element(v.begin(), v.end())
#define pb(x) push_back(x)
#define foru(i, n, k, x) for (int i = n; i < k; i += x)
#define ford(i, n, k, x) for (int i = n; i >= k; i -= x)
#define forn(i, k) foru(i, 0, k, 1)

void setIO(string name) {
	cin.tie(0)->sync_with_stdio(0);
	if (name != "") {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}

void solve() {
    int n, e = 0, o = 0;
    cin >> n;
    forn(i, n) {
        int a; cin >> a;
        if (a % 2 == 0) ++e;
        else ++o;
    }
    while(o > e) {
        o -= 2; ++e;
    }
    cout << (e > o + 1 ? 2*o + 1 : e + o);
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}	