//Problem: https://codeforces.com/contest/493/problem/A

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
    string H, A; int n;
    cin >> H >> A >> n;
    map<pair<string, int>, int> lol;
    while(n--) {
        int m, num; string side, card;
        cin >> m >> side >> num >> card;
        pair<string, int> p = mp(side, num);
        if (lol[p] >= 2) continue;
        lol[p] += (card == "y" ? 1 : 2);
        if (lol[p] >= 2) {
            cout << (side == "h" ? H : A) << ' ' << num << ' ' << m << '\n';
        }
    }
}
 
int32_t main() {
    setIO("");
    // int t; cin >> t; while(t--)
    solve();
}	
