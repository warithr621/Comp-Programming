// https://codeforces.com/contest/1689/problem/A

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
    //code
    int n,m,k; cin >> n >> m >> k;
    string a, b; cin >> a >> b;
    s(a); s(b);
    int cura = 0, curb = 0, cnt = 0;
    bool A = true;
    while(cura < n && curb < m) {
        char ca = a[cura], cb = b[curb];
        if (ca < cb) { //better to print char a
            if (!(cnt >= k && A)) { //the only time we CANT print char a is if cnt >= k and A
                cout << ca;
                if (A) ++cnt;
                else cnt = 1;
                ++cura;
                A = 1;
            } else {
                A = 0;
                cnt = 1;
                cout << cb;
                ++curb;
            }
        } else { //better to print char b
            if (!(cnt >= k && !A)) {
                cout << cb;
                if (!A) ++cnt;
                else cnt = 1;
                ++curb;
                A = 0;
            } else {
                A = 1;
                cnt = 1;
                cout << ca;
                ++cura;
            }
        }
        // cout << '\n';
        // cout << cnt << ' ' << (A ? "true" : "false") << '\n';
    }
    cout << '\n';
}
 
int32_t main() {
    setIO("");
    int t = 1;
    cin >> t;
    while(t--) solve();
}