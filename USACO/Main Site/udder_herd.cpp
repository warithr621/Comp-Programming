//Problem: 2021 January Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=1083

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

int find(string s, char c) {
    forn(i, s.length()) if (s[i] == c) return i;
    return -1;
}

void solve() {
    string a, s; cin >> a >> s;
    int ans = 1, t = 0;
    forn(i, s.length()) {
        int f = find(a, s[i]);
        if (f <= t) ++ans;
        t = f;
    }
    cout << ans << '\n';
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}	