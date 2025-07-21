// https://codeforces.com/contest/1714/problem/E

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

bool cycle(int n) {
    return n % 2 == 0 && n != 0;
}

void twice() {
    //code
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    order(a);
    int mx = a[n-1];
    int nmx = -1;

    for (int i = 0; i < n; i++) {
        //first, we only need to take one step
        a[i] += a[i] % 10;
        //now we should guaranteed be in a cycle
        if (a[i] % 10 == 0) continue; //lmao screw zeros

        int times = (mx - a[i] + 19) / 20;
        a[i] += times * 20;
        nmx = max(nmx, a[i]);
    }
    // for (int i : a) cout << i << ' ';
    // cout << '\n';

    if (nmx == -1) nmx = a[0];

    bool b = true;
    for (int i : a) {
        if (i == nmx) continue;
        while(i < nmx) {
            if (i % 10 == 0) break;
            i += i % 10;
        }
        b &= i == nmx;
        // cout << i << '\n';
    }
    cout << (b ? "Yes" : "No") << '\n';
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) twice();
}