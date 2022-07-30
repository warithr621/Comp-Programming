// https://codeforces.com/contest/1689/problem/B

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

// void troll(vi p) {
//     int n = p.size();
//     vi fst(n), sec(n);
//     for (int i = 0; i < n; i++) {
//         fst[i] = p[i] + 1;
//         sec[i] = p[i] - 1;
//         if (fst[i] > n) fst[i] = 1;
//         if (sec[i] < 1) sec[i] = n;
//     }
//     bool F = 1, S = 1;
//     for (int i = 0; i < n; i++) {
//         if (fst[i] == p[i]) F = 0;
//         if (sec[i] == p[i]) S = 0;
//     }
//     if (!F && !S) {
//         cout << "-1\n";
//         return;
//     }
//     if (!S) {
//         for (int i : fst) cout << i << ' ';
//         cout << '\n';
//         return;
//     }
//     if (!F) {
//         for (int i : sec) cout << i << ' ';
//         cout << '\n';
//         return;
//     }
//     if (fst[0] < sec[0]) {
//         for (int i : fst) cout << i << ' ';
//         cout << '\n';
//     } else {
//         for (int i : sec) cout << i << ' ';
//         cout << '\n';
//     }
// }

void solve() {
    //code
    int n; cin >> n;
    vi p(n);
    forn(i, n) cin >> p[i];
    if (n == 1) {
        cout << "-1\n";
        return;
    }
    vi q(n);
    forn(i, n) q[i] = i+1;
    forn(i, n) {
        int cnt = 0;
        forn(j, n) {
            if (p[j] == q[j]) {
                int idx = (j == n-1 ? n-2 : j+1);
                int temp = q[j];
                q[j] = q[idx];
                q[idx] = temp;
                ++cnt;
            }
        }
        if (cnt == 0) break;
    }
    forn(i, n) cout << q[i] << ' ';
    cout << '\n';
}
 
int32_t main() {
    setIO("");
    int t = 1;
    cin >> t;
    while(t--) solve();
}