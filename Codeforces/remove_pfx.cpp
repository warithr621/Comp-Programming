// https://codeforces.com/contest/1714/problem/B

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
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    set<int> s;
    int right = n-1;
    while(right >= 0) {
        if (s.count(a[right])) break;
        s.insert(a[right]);
        --right;
    }
    cout << ++right << '\n';
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) twice();
}