// CSES Gray Code

#include <bits/stdc++.h>
#include <unordered_map>
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
 
int fact(int x) {
    if (x <= 1) return 1;
    return x * fact(x - 1);
}
 
void solve() {
    int n; cin >> n;
    vector<string> a = {"0", "1"};
    int cnt = 1;
    while(cnt < n) {
        vector<string> L = a;
        vector<string> R(L.size());
        forn(i, L.size()) R[i] = L[L.size() - i - 1];
        forn(i, L.size()) L[i] = "0" + L[i];
        forn(i, R.size()) R[i] = "1" + R[i];
        vector<string> temp(L.size() * 2);
        forn(i, L.size()) temp[i] = L[i];
        forn(i, R.size()) temp[i + L.size()] = R[i];
        a = temp;
        ++cnt;
    }
    forn(i, a.size()) cout << a[i] << '\n';
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}