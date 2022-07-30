// CSES Repetitions

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define s(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
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
    string s; cin >> s;
    int n = s.size();
    int a = 0, t = 0, c = 0, g = 0;
    int curr = 1;
    char x = s[0];
    for (int i = 1; i < n; i++) {
        if (s[i] == x) ++curr;
        else {
            if (x == 'A') a = max(a, curr);
            if (x == 'T') t = max(t, curr);
            if (x == 'C') c = max(c, curr);
            if (x == 'G') g = max(g, curr);
            curr = 1;
            x = s[i];
        }
    }
    if (x == 'A') a = max(a, curr);
    if (x == 'T') t = max(t, curr);
    if (x == 'C') c = max(c, curr);
    if (x == 'G') g = max(g, curr);
    vector<int> test = {a, t, c, g};
    cout << maxvec(test);
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}