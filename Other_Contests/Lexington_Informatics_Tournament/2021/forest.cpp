//Source: 2021 Lexington Informatics Tournament Standard Round B (Forest)

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef vector<string> vs;
typedef vector<char> vc;
typedef map<int, int> mii;
typedef pair<int, int> pii;
#define pi 3.141592653589793
#define s(v) sort(v.begin(), v.end())
#define sped cin.tie(0)->sync_with_stdio(0)
#define rev(v) sort(v.rbegin(), v.rend())
#define bs(v, s) binary_search(v.begin(), v.end(), s)
#define mp make_pair
#define pb(x) push_back(x)
#define foru(i, n, k, x) for (int i = n; i < k; i += x)
#define ford(i, n, k, x) for (int i = n; i >= k; i -= x)
#define forn(i, k) foru(i, 0, k, 1)

int coline(int a[2], int b[2], int c[2]) {
    if ((a[0] - c[0]) * (b[1] - c[1]) == (a[1] - c[1]) * (b[0] - c[0])) return 1;
    else return 0;
}

void solve() {
    int n; cin >> n;
    int a[n][2];
    forn(i, n) cin >> a[i][0] >> a[i][1];
    int mxp = 0;
    forn(i, n) {
        for (int j = i+1; j < n; j++) {
            int sum = 0;
            forn(k, n) {
                sum += coline(a[i], a[j], a[k]);
            }
            mxp = max(mxp, sum);
        }
    }
    cout << (mxp == 0 ? n : mxp) << '\n';
}
 
int main() {
    sped;
    // int t; cin >> t; while(t--)
    solve();
}
