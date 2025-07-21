// https://codeforces.com/contest/1759/problem/C

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)
 
void solve() {
    //code
    int l,r,x,a,b; cin >> l >> r >> x >> a >> b;
 
    if (a == b) {
        cout << "0\n";
        return;
    }
 
    if (abs(a-b) >= x) {
        cout << "1\n";
        return;
    }
 
    // try to go to a -> r -> b or a -> l -> b: 2 moves
    // try to go to a->r->l->b or a->l->r->b: 3 moves
 
    if (abs(a-r) >= x && abs(r-b) >= x || abs(a-l) >= x && abs(l-b) >= x) {
        cout << "2\n";
        return;
    }
 
    if (abs(a-r) >= x && abs(r-l) >= x && abs(l-b) >= x || abs(a-l) >= x && abs(l-r) >= x && abs(r-b) >= x) {
        cout << "3\n";
        return;
    }
 
    cout << "-1\n";
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}