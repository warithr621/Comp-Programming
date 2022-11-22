//walrus
//https://codeforces.com/contest/1203/problem/F1

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

bool custom_comp(const pii& a, const pii& b) {
    return a.fst + a.sec > b.fst + b.sec;
}

void solve() {
    //code
    int n,r; cin >> n >> r;
    vector<pii> pos, neg;
    forn(i, n) {
        int x,y; cin >> x >> y;
        if (y >= 0) pos.pb(mp(x, y));
        else neg.pb(mp(x, y));
    }
    s(pos); sort(neg.begin(), neg.end(), custom_comp);
    int used = 0;
    for (auto p : pos) {
        if (r >= p.fst) {
            r += p.sec;
            ++used;
        }
        if (r < 0) {
            cout << "NO\n";
            return;
        }
    }

    for (auto p : neg) {
        if (r >= p.fst) {
            r += p.sec;
            ++used;
        }
        if (r < 0) {
            cout << "NO\n";
            return;
        }
    }

    cout << (used == n ? "YES" : "NO")<< '\n';
}
 
int32_t main() {
    setIO("");
    int t = 1;
    // cin >> t;
    while(t--) solve();
}