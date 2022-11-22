// https://codeforces.com/contest/1716/problem/A

#include <bits/stdc++.h>
using namespace std;
#define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
#define order(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
#define pb(x) push_back(x)
#define forn(i, ty) for(int i = 0; i < ty; i++)

void twice() {
    //my sol in-contest
    int n; cin >> n;
    if (n == 1) cout << "2\n";
    else if (n <= 3) cout << "1\n";
    else if (n == 4) cout << "2\n";
    else if (n % 3 == 0) cout << n/3 << '\n';
    else cout << (n+2) / 3 << '\n';
}

void solve() {
    //alt sol thats like infinitely easier
    int n; cin >> n;
    if (n == 1) cout << "2\n";
    else cout << (n+2) / 3 << '\n';
}
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}