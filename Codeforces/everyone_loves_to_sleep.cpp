// https://codeforces.com/contest/1714/problem/A

#include <bits/stdc++.h>
using namespace std;
#define int long long
typedef vector<int> vi;
typedef map<int, int> mii;
typedef pair<int, int> pii;
#define order(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
#define mp make_pair
#define pb(x) emplace_back(x)
#define forn(i, ty) for(int i = 0; i < ty; i++)

void twice() {
    //code
    int n,h,m; cin >> n >> h >> m;
    vi H(n), M(n);
    forn(i, n) cin >> H[i] >> M[i];
    int ans = 2000;
    forn(i, n) {
        ans = min(ans, ((H[i] - h) * 60 + M[i] - m + 1440) % 1440);
    }
    cout << ans/60 << ' ' << ans%60 << '\n';
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) twice();
}